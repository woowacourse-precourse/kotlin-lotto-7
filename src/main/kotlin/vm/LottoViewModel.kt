package vm

import domain.enums.Rank
import domain.lotto.Lotto
import domain.model.PurchaseState
import domain.validator.InputValidate
import sam.LottoFactory
import util.convertRoundAtTwoDecimal
import java.util.TreeSet

class LottoViewModel(
    private val validator: InputValidate,
    private val lottoFactory: LottoFactory
) {

    var state = PurchaseState()
        private set

    fun checkPaymentValidation(pay: String): Pair<String, Int> =
        validator.payValidation(pay)

    fun checkWinningNumberValidation(winningNumber: String): List<Int> =
        validator.winningNumberValidation(winningNumber)

    fun checkBonusNumberValidation(bonusNumber: String): Int =
        validator.bonusNumberValidation(bonusNumber)

    fun onCompleteInputPayment(pay: Int) {
        state = state.copy(purchaseLottoCount = pay)
        pickLotto()
    }

    fun onCompleteInputWinningNumber(winningNumber: List<Int>) {
        state = state.copy(winningNumber = winningNumber)
    }

    fun onCompleteInputBonusNumber(bonusNumber: Int) {
        state = state.copy(bonusNumber = bonusNumber)
        getLottoResult()
    }

    private fun pickLotto() {
        val purchaseLottoAmount = state.purchaseLottoCount
        val pickedLotto = mutableListOf<TreeSet<Int>>()
        repeat(purchaseLottoAmount) {
            pickedLotto.add(lottoFactory())
        }
        state = state.copy(pickedLotto = pickedLotto)
    }

    private fun getLottoResult() {
        val lotto = Lotto(state.winningNumber)
        val updatedReward = state.reward.copy()

        state.pickedLotto.map {
            val matches = lotto.getMatches(it, state.bonusNumber)
            if (matches != Rank.NONE) {
                updatedReward.winning[matches] = updatedReward
                    .winning
                    .getOrDefault(matches, 0) + 1
            }
        }

        state = state.copy(reward = updatedReward)
        calculateRateOfReturn()
    }

    private fun calculateRateOfReturn() {
        // 당첨 금액
        var winningMoney = 0L
        val totalPurchaseAmount = state.purchaseLottoCount * 1000
        state.reward.winning.mapKeys {
            winningMoney += it.key.getReword() * it.value
        }

        if (winningMoney != 0L) {
            val rateOfReturn = (winningMoney.toDouble() / totalPurchaseAmount) * 100
            val formattedRateOfReturn = rateOfReturn.convertRoundAtTwoDecimal()
            state = state.copy(rateOfReturn = formattedRateOfReturn)
        }
    }
}