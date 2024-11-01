package view

import domain.enums.Input
import util.ext.printWithSquareBracket
import util.retryWhenNoException
import vm.LottoViewModel

class MainView(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val viewModel: LottoViewModel
) {
    init {
        getPayment()
        getWinningNumber()
        getBonusNumber()
        outputView.printRateOfReturn(viewModel.state.rateOfReturn)
    }

    private fun getPayment() {
        retryWhenNoException {
            outputView.printGuideMessage(Input.INPUT_PAY.toString())
            val pay = inputView.userInput()
            val validPayment = viewModel.checkPaymentValidation(pay)
            printAndSetPurchaseAmount(validPayment.first, validPayment.second)
        }
    }

    private fun getWinningNumber() {
        retryWhenNoException {
            outputView.printWithLineBreak(Input.INPUT_WINNING_NUMBER.toString())
            val winningNumber = inputView.userInput()
            val validWinningNumber = viewModel.checkWinningNumberValidation(winningNumber)
            printAndSetWinningNumber(validWinningNumber)
        }
    }

    private fun getBonusNumber() {
        retryWhenNoException {
            outputView.printGuideMessage(Input.INPUT_BONUS_NUMBER.toString())
            val bonusNumber = inputView.userInput()
            viewModel.checkBonusNumberValidation(bonusNumber)
            printAndSetWinningStatics()
        }
    }

    private fun printAndSetPurchaseAmount(msg: String, purchase: Int) {
        outputView.printWithLineBreak(msg)
        viewModel.onCompleteInputPayment(purchase)
        viewModel.state.pickedLotto.forEach { lotto ->
            lotto.printWithSquareBracket()
        }
    }

    private fun printAndSetWinningNumber(winningNumber: List<Int>) {
        outputView.lineBreak()
        viewModel.onCompleteInputWinningNumber(winningNumber)
    }

    private fun printAndSetWinningStatics() {
        outputView.printWinningStatics()
        val result = viewModel.state.reward.winning
        outputView.printRankResult(result)
    }
}