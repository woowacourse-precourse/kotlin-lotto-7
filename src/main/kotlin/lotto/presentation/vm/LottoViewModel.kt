package lotto.presentation.vm

import lotto.data.LottoDataSource
import lotto.domain.calculator.Calculate
import lotto.domain.enums.Rank
import lotto.domain.lotto.Lotto
import lotto.domain.validator.InputValidate
import lotto.presentation.vm.model.PurchaseState
import java.util.TreeSet

class LottoViewModel(
    private val validator: InputValidate,
    private val calculator: Calculate,
    private val lottoDataSource: LottoDataSource
) {

    var state = PurchaseState()
        private set

    fun checkPaymentValidation(pay: String): Pair<String, Int> =
        validator.payValidation(pay)

    fun checkWinningNumberValidation(winningNumber: String): List<Int> =
        validator.winningNumberValidation(winningNumber)

    fun checkBonusNumberValidation(bonusNumber: String) {
        val validBonusNumber = validator.bonusNumberValidation(bonusNumber)
        onCompleteInputBonusNumber(validBonusNumber)
    }

    fun onCompleteInputPayment(pay: Int) {
        state = state.copy(purchaseLottoCount = pay)
        pickLotto()
    }

    fun onCompleteInputWinningNumber(winningNumber: List<Int>) {
        state = state.copy(winningNumber = winningNumber)
    }

    private fun onCompleteInputBonusNumber(bonusNumber: Int) {
        state = state.copy(bonusNumber = bonusNumber)
        getLottoResult()
    }

    private fun pickLotto() {
        val purchaseLottoAmount = state.purchaseLottoCount
        val pickedLotto = mutableListOf<TreeSet<Int>>()
        repeat(purchaseLottoAmount) {
            pickedLotto.add(lottoDataSource())
        }
        state = state.copy(pickedLotto = pickedLotto)
    }

    private fun getLottoResult() {
        val lotto = Lotto(state.winningNumber)
        val updatedReward = state.winningResult.toMutableMap()

        state.pickedLotto.map {
            val matches = lotto.getMatches(it, state.bonusNumber)
            modifyRewardByMatches(matches, updatedReward)
        }

        state = state.copy(winningResult = updatedReward)
        getRateOfReturn()
    }

    private fun getRateOfReturn() {
        val winningMoney = calculator.calculateWinningMoney(state.winningResult)

        if (winningMoney != 0L) {
            val purchaseAmount = state.purchaseLottoCount
            val rateOfReturn = calculator.calculateRateOfReturn(winningMoney, purchaseAmount)
            state = state.copy(rateOfReturn = rateOfReturn)
        }
    }

    private fun modifyRewardByMatches(matches: Rank, updatedReward: MutableMap<Rank, Int>) {
        if (matches != Rank.NONE) {
            updatedReward[matches] = updatedReward.getOrDefault(matches, 0) + 1
        }
    }
}