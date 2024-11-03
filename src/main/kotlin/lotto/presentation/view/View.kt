package lotto.presentation.view

import camp.nextstep.edu.missionutils.Console.close
import camp.nextstep.edu.missionutils.Console.readLine
import lotto.domain.enums.Input
import lotto.domain.printer.Printer
import lotto.domain.util.retryWhenNoException
import lotto.presentation.vm.LottoViewModel

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
    }

    private fun validatePayment(pay: String) {
        viewModel.checkPaymentValidation(pay)
        printPurchasedLottoCount()
    }

    private fun printPurchasedLottoCount() {
        val msg = viewModel.state.purchaseInfo.guideMessage
        printer.printWithLineBreak(msg)
        printPickedLotto()
    }

    private fun printPickedLotto() {
        viewModel.pickLotto()
        val msg = viewModel.state.lotto.guideMessage
        printer.printMessage(msg)
    }

    private fun validateWinningNumber(winningNumber: String) {
        viewModel.checkWinningNumberValidation(winningNumber)
        printer.lineBreak()
    }

    private fun validateBonusNumber(bonusNumber: String) {
        viewModel.checkBonusNumberValidation(bonusNumber)
        printer.printWinningMessage()
        printer.printWithLineBreak(viewModel.state.winningResult.guideMessage)
    }

    private fun printResult() {
        viewModel.getRateOfReturn()
        val rateOfReturn = viewModel.state.rateOfReturn
        printer.printMessage(rateOfReturn)
        close()
    }
}