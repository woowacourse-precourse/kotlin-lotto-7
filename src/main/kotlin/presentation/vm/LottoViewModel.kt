package presentation.vm

import data.LottoDataSource
import domain.calculator.Calculate
import domain.enums.Output.Companion.totalRateOfReturnFormat
import domain.enums.Rank
import domain.lotto.Lotto
import domain.util.ext.joinToStringWithSquareBracket
import presentation.vm.model.PurchaseState
import domain.validator.InputValidate
import java.util.TreeSet

class LottoViewModel(
    private val validator: InputValidate,
    private val calculator: Calculate,
    private val lottoDataSource: LottoDataSource
) {

    private var _state = PurchaseState()
    val state: PurchaseState get() = _state

    fun checkPaymentValidation(pay: String) {
        val validPayment = validator.payValidation(pay)
        _state = _state.copy(
            purchaseLottoCount = validPayment.second,
            message = validPayment.first
        )
    }

    fun checkWinningNumberValidation(winningNumber: String) {
        val validWinningNumber = validator.winningNumberValidation(winningNumber)
        _state = _state.copy(winningNumber = validWinningNumber)
    }

    fun checkBonusNumberValidation(bonusNumber: String) {
        val validBonusNumber = validator.bonusNumberValidation(bonusNumber)
        _state = _state.copy(bonusNumber = validBonusNumber)
        getLottoResult()
    }

    fun pickLotto() {
        val purchaseLottoAmount = _state.purchaseLottoCount
        val pickedLotto = mutableListOf<TreeSet<Int>>()
        repeat(purchaseLottoAmount) {
            pickedLotto.add(lottoDataSource())
        }
        _state = _state.copy(
            pickedLotto = pickedLotto,
            message = pickedLotto.joinToString(",\n") {
                it.joinToStringWithSquareBracket()
            }
        )
    }

    private fun getLottoResult() {
        val lotto = Lotto(_state.winningNumber)
        val updatedWinningResult = _state.winningResult.toMutableMap()

        _state.pickedLotto.map {
            val matches = lotto.getMatches(it, _state.bonusNumber)
            modifyWinningByMatches(matches, updatedWinningResult)
        }
        val message = updatedWinningResult.map { (rank, winningCount) ->
            rank.getFormattedRankResult(winningCount)
        }
        _state = _state.copy(
            winningResult = updatedWinningResult,
            message = message.joinToString("\n")
        )
    }

    fun getRateOfReturn() {
        val winningMoney = calculator.calculateWinningMoney(_state.winningResult)

        if (winningMoney != 0L) {
            val purchaseAmount = _state.purchaseLottoCount
            val rateOfReturn = calculator.calculateRateOfReturn(winningMoney, purchaseAmount)
            _state = _state.copy(message = totalRateOfReturnFormat(rateOfReturn))
        }
    }

    private fun modifyWinningByMatches(matches: Rank, currentWinning: MutableMap<Rank, Int>) {
        if (matches != Rank.NONE) {
            currentWinning[matches] = currentWinning.getOrDefault(matches, 0) + 1
        }
    }
}