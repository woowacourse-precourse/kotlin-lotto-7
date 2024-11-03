package presentation.view

import camp.nextstep.edu.missionutils.Console.readLine
import domain.enums.Input
import presentation.vm.LottoViewModel
import domain.util.retryWhenNoException
import domain.printer.Printer

class View(
    private val printer: Printer,
    private val viewModel: LottoViewModel
) {

    init {
        getPayment()
        getWinningNumber()
        getBonusNumber()
        printResult()
    }

    private fun getPayment() = retryWhenNoException {
        printer.printMessage(Input.INPUT_PAY.toString())
        val pay = readLine()
        validatePayment(pay)
    }

    private fun getWinningNumber() = retryWhenNoException {
        printer.printWithLineBreak(Input.INPUT_WINNING_NUMBER.toString())
        val winningNumber = readLine()
        validateWinningNumber(winningNumber)
    }

    private fun getBonusNumber() = retryWhenNoException {
        printer.printMessage(Input.INPUT_BONUS_NUMBER.toString())
        val bonusNumber = readLine()
        validateBonusNumber(bonusNumber)
        viewModel.getRateOfReturn()
    }

    private fun validatePayment(pay: String) {
        viewModel.checkPaymentValidation(pay)
        printer.printWithLineBreak(viewModel.state.message)
        printPickedLotto()
    }

    private fun printPickedLotto() {
        viewModel.pickLotto()
        printer.printWithLineBreak(viewModel.state.message)
    }

    private fun validateWinningNumber(winningNumber: String) {
        viewModel.checkWinningNumberValidation(winningNumber)
        printer.lineBreak()
    }

    private fun validateBonusNumber(bonusNumber: String) {
        viewModel.checkBonusNumberValidation(bonusNumber)
        printWinningResult()
    }

    private fun printWinningResult() {
        printer.printWinningMessage()
        printer.printMessage(viewModel.state.message)
    }

    private fun printResult() {
        printer.printMessage(viewModel.state.message)
    }
}