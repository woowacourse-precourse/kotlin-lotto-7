package view

import domain.enums.Output
import domain.enums.Rank
import util.convertWithDigitComma

class OutputView {
    fun printGuideMessage(message: String) {
        println(message)
    }

    fun printWithLineBreak(msg: String) {
        lineBreak()
        println(msg)
    }

    fun printWinningStatics() {
        lineBreak()
        println(Output.WINNING_STATISTICS)
        println(Output.THREE_HYPHEN)
    }

    fun printRankResult(result: Map<Rank, Int>){
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

    fun printRateOfReturn(rateOfReturn: String) {
        println(Output.totalRateOfReturnFormat(rateOfReturn))
    }

    fun lineBreak() = println()
}