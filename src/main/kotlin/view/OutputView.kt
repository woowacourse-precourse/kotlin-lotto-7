package view

import domain.enums.Output
import domain.enums.Output.Companion.totalRateOfReturnFormat
import domain.enums.Rank
import domain.util.ext.joinToStringWithSquareBracket
import java.util.TreeSet

class OutputView {
    fun printGuideMessage(message: String) {
        println(message)
    }

    fun printWithLineBreak(msg: String) {
        lineBreak()
        println(msg)
    }

    fun printPurchaseLotto(purchaseLotto: List<TreeSet<Int>>) {
        purchaseLotto.forEach { lotto ->
            println(lotto.joinToStringWithSquareBracket())
        }
    }

    fun printWinningStatics() {
        lineBreak()
        println(Output.WINNING_STATISTICS)
        println(Output.THREE_HYPHEN)
    }

    fun printResult(result: Map<Rank, Int>) {
        result.map { (rank, winningCount) ->
            val formattedResult = rank.getFormattedRankResult(winningCount)
            println(formattedResult)
        }
    }

    fun printRateOfReturn(rateOfReturn: String) {
        println(totalRateOfReturnFormat(rateOfReturn))
    }

    fun lineBreak() = println()
}