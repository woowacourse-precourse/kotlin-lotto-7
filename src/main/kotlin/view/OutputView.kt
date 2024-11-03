package view

import domain.enums.Output
import domain.enums.Output.Companion.matchCountFormat
import domain.enums.Output.Companion.matchingNumberFormat
import domain.enums.Output.Companion.totalRateOfReturnFormat
import domain.enums.Rank
import domain.enums.Rank.Companion.getRank
import domain.util.convertWithDigitComma
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
        result.map { (rank, matchCount) ->
            val reword = rank.getReword().convertWithDigitComma()
            val matchCountFormat = matchCountFormat(rank.getMatchingCount())
            val matchNumberFormat = matchingNumberFormat(reword, matchCount)

            printRankResult(rank, matchCountFormat, matchNumberFormat)
        }
    }

    private fun printRankResult(rank: Rank, matchCountFormat: String, matchNumberFormat: String) {
        when (rank) {
            Rank.SECOND -> printSecondRankResult(matchCountFormat, matchNumberFormat)
            else -> printOtherRankResult(matchCountFormat, matchNumberFormat)
        }
    }

    private fun printSecondRankResult(matchCountFormat: String, matchNumberFormat: String) {
        val bonusMatchCount = Output.BONUS_MATCH_COUNT.toString()
        println("$matchCountFormat$bonusMatchCount $matchNumberFormat")
    }

    private fun printOtherRankResult(matchCountFormat: String, matchNumberFormat: String) {
        println("$matchCountFormat $matchNumberFormat")
    }

    fun printRateOfReturn(rateOfReturn: String) {
        println(totalRateOfReturnFormat(rateOfReturn))
    }

    fun lineBreak() = println()
}