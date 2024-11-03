package presentation.view

import domain.enums.Input
import domain.util.retryWhenNoException
import presentation.vm.LottoViewModel
import camp.nextstep.edu.missionutils.Console.readLine

class View(
    private val outputView: OutputView,
    private val viewModel: LottoViewModel
) {
    init {
        getPayment()
        getWinningNumber()
        getBonusNumber()
        outputView.printRateOfReturn(viewModel.state.rateOfReturn)
    }

    private fun getPayment() = retryWhenNoException {
        outputView.printGuideMessage(Input.INPUT_PAY.toString())
        val pay = readLine()
        val validPayment = viewModel.checkPaymentValidation(pay)
        setPurchaseAmount(validPayment.first, validPayment.second)
    }

    private fun getWinningNumber() = retryWhenNoException {
        outputView.printWithLineBreak(Input.INPUT_WINNING_NUMBER.toString())
        val winningNumber = readLine()
        val validWinningNumber = viewModel.checkWinningNumberValidation(winningNumber)
        setWinningNumber(validWinningNumber)
    }

    private fun getBonusNumber() = retryWhenNoException {
        outputView.printGuideMessage(Input.INPUT_BONUS_NUMBER.toString())
        val bonusNumber = readLine()
        viewModel.checkBonusNumberValidation(bonusNumber)
        setWinningStatics()
    }

    private fun setPurchaseAmount(msg: String, purchase: Int) {
        outputView.printWithLineBreak(msg)
        viewModel.onCompleteInputPayment(purchase)
        outputView.printPurchaseLotto(viewModel.state.pickedLotto)
    }

    private fun setWinningNumber(winningNumber: List<Int>) {
        outputView.lineBreak()
        viewModel.onCompleteInputWinningNumber(winningNumber)
    }

    private fun setWinningStatics() {
        outputView.printWinningStatics()
        val result = viewModel.state.winningResult
        outputView.printResult(result)
    }
}