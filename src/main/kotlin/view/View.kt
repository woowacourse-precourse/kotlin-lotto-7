package view

import camp.nextstep.edu.missionutils.Console.readLine
import domain.enums.Input
import domain.validator.InputValidator
import util.retryWhenNoException
import vm.LottoViewModel

class View(
    private val validator: InputValidator,
    private val viewModel: LottoViewModel
) {
    init {
        getPayment()
        getWinningNumber()
        getBonusNumber()
    }

    private fun getPayment() {
        retryWhenNoException {
            println(Input.INPUT_PAY.toString())
            val pay = readLine()
            val output = validator.payValidation(pay)
            printAndSetPurchase(output.first, output.second)
        }
    }

    private fun getWinningNumber() {
        retryWhenNoException {
            println(Input.INPUT_WINNING_NUMBER.toString())
            val winningNumber = readLine()
            val validWinningNumber = validator.winningNumberValidation(winningNumber)
            printAndSetWinningNumber(validWinningNumber)
        }
    }

    private fun getBonusNumber() {
        retryWhenNoException {
            println(Input.INPUT_BONUS_NUMBER.toString())
            val bonusNumber = readLine()
            val validBonusNumber = validator.bonusNumberValidation(bonusNumber)
            viewModel.onCompleteInputBonusNumber(validBonusNumber)
        }
    }

    private fun printAndSetPurchase(msg: String, purchase: Int){
        lineBreak()
        println(msg)
        viewModel.onCompleteInputPayment(purchase)
        lineBreak()
    }

    private fun printAndSetWinningNumber(winningNumber: List<Int>){
        lineBreak()
        viewModel.onCompleteInputWinningNumber(winningNumber)
    }

    private fun lineBreak() = println()
}