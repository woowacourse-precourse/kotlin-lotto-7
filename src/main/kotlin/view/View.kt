package view

import camp.nextstep.edu.missionutils.Console.readLine
import domain.enums.Input
import domain.enums.Output
import domain.validator.InputValidator
import util.retryWhenNoException
import vm.LottoViewModel

class InputView(
    private val validator: InputValidator,
    private val viewModel: LottoViewModel
) {
    init {
        getPayment()
    }

    private fun getPayment() {
        retryWhenNoException {
            println(Input.INPUT_PAY.toString())
            val pay = readLine()
            val output = validator.payValidation(pay)
            onCompleteInputPayment(output.first, output.second)
        }
    }

    private fun getWinningNumber() {
        val winningNumber = retryWhenNoException {
            println(Input.INPUT_WINNING_NUMBER.toString())
            val winningNumber = readLine()
            validator.winningNumberValidation(winningNumber)
        }
    }

    private fun onCompleteInputPayment(msg: String, purchase: Int){
        lineBreak()
        println(msg)
        viewModel.onCompleteInputPayment(purchase)
    }

    private fun lineBreak() = println()
}