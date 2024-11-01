package view

import camp.nextstep.edu.missionutils.Console.readLine
import domain.enums.Input
import domain.enums.Output
import domain.enums.Rank
import util.convertWithDigitComma
import util.ext.printWithSquareBracket
import util.retryWhenNoException
import vm.LottoViewModel

class View(private val viewModel: LottoViewModel) {
    init {
        getPayment()
        getWinningNumber()
        getBonusNumber()
        printRateOfReturn()
    }

    private fun getPayment() {
        retryWhenNoException {
            println(Input.INPUT_PAY.toString())
            val pay = readLine()
            val output = viewModel.checkPaymentValidation(pay)
            printAndSetPurchase(output.first, output.second)
        }
    }

    private fun getWinningNumber() {
        retryWhenNoException {
            lineBreak()
            println(Input.INPUT_WINNING_NUMBER.toString())
            val winningNumber = readLine()
            val validWinningNumber = viewModel.checkWinningNumberValidation(winningNumber)
            printAndSetWinningNumber(validWinningNumber)
        }
    }

    private fun getBonusNumber() {
        retryWhenNoException {
            println(Input.INPUT_BONUS_NUMBER.toString())
            val bonusNumber = readLine()
            viewModel.checkBonusNumberValidation(bonusNumber)
            printWinningStatics()
        }
    }

    private fun printAndSetPurchase(msg: String, purchase: Int) {
        lineBreak()
        println(msg)
        viewModel.onCompleteInputPayment(purchase)
        viewModel.state.pickedLotto.forEach { lotto ->
            lotto.printWithSquareBracket()
        }
    }

    private fun printAndSetWinningNumber(winningNumber: List<Int>) {
        lineBreak()
        viewModel.onCompleteInputWinningNumber(winningNumber)
    }

    private fun printWinningStatics() {
        lineBreak()
        println(Output.WINNING_STATISTICS)
        println(Output.THREE_HYPHEN)
        val result = viewModel.state.reward.winning
        result.map { (key, value) ->
            if (key.getReword() == Rank.SECOND.getReword()) printSecondRankResult(key, value)
            else printOtherRankResult(key, value)
        }
    }

    private fun printSecondRankResult(key: Rank, value: Int) {
        val matchCountFormat = Output.matchCountFormat(key.getMatchingCount())
        val bonusMatchCount = Output.BONUS_MATCH_COUNT.toString()
        val matchNumberFormat =
            Output.matchingNumberFormat(key.getReword().convertWithDigitComma(), value)
        println(
            "$matchCountFormat$bonusMatchCount $matchNumberFormat"
        )
    }

    private fun printOtherRankResult(key: Rank, value: Int) {
        val matchCountFormat = Output.matchCountFormat(key.getMatchingCount())
        val matchNumberFormat =
            Output.matchingNumberFormat(key.getReword().convertWithDigitComma(), value)
        println("$matchCountFormat $matchNumberFormat")
    }

    private fun printRateOfReturn() {
        println(Output.totalRateOfReturnFormat(viewModel.state.rateOfReturn))
    }

    private fun lineBreak() = println()
}