package lotto.presenter

import lotto.validation.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class InputPresenter(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun onPurchaseAmountInput(): Int {
        while (true) {
            try {
                val amount = inputView.readPurchaseAmount()
                outputView.printNewLine()
                InputValidator.validatePurchaseAmount(amount)
                return amount.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun onWinningNumbersInput(): List<Int> {
        while (true) {
            try {
                val numbers = inputView.readWinningNumbers()
                outputView.printNewLine()
                // TODO 검증예외처리
                return numbers.split(",").map { it.toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun onBonusNumberInput(): Int {
        while (true) {
            try {
                val bonusNumber = inputView.readBonusNumber()
                outputView.printNewLine()
                // TODO 검증예외처리
                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}