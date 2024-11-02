package view

import domain.enums.Output
import domain.enums.Output.Companion.matchCountFormat
import domain.enums.Output.Companion.matchingNumberFormat
import domain.enums.Output.Companion.totalRateOfReturnFormat
import domain.enums.Rank
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

    fun printRankResult(result: Map<Rank, Int>) {
        result.map { (key, value) ->
            val reword = key.getReword()
            when (reword) {
                Rank.SECOND.getReword() -> printSecondRankResult(key, value)
                else -> printOtherRankResult(key, value)
            }
        }
    }

    private fun printSecondRankResult(key: Rank, value: Int) {
        val matchCountFormat = matchCountFormat(key.getMatchingCount())
        val bonusMatchCount = Output.BONUS_MATCH_COUNT.toString()
        val matchNumberFormat = matchingNumberFormat(key.getReword().convertWithDigitComma(), value)
        println("$matchCountFormat$bonusMatchCount $matchNumberFormat")
    }

    private fun printOtherRankResult(key: Rank, value: Int) {
        val matchCountFormat = matchCountFormat(key.getMatchingCount())
        val matchNumberFormat = matchingNumberFormat(key.getReword().convertWithDigitComma(), value)
        println("$matchCountFormat $matchNumberFormat")
    }

    fun printRateOfReturn(rateOfReturn: String) {
        println(totalRateOfReturnFormat(rateOfReturn))
    }

    fun lineBreak() = println()
}