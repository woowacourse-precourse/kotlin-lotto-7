package lotto.presenter

import lotto.extensions.splitByComma
import lotto.extensions.toIntList
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
                InputValidator.validateWinningNumbers(numbers)
                return numbers.splitByComma().toIntList()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun onBonusNumberInput(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                val bonusNumber = inputView.readBonusNumber()
                outputView.printNewLine()
                InputValidator.validateBonusNumber(bonusNumber, winningNumbers)
                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}