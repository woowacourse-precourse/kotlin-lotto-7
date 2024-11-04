package view

import model.WinCount
import values.Content

class outputMessage {
    fun printLottoList(count: Int, randomLottoList: MutableMap<Int, List<Int>>) {
        println(count.toString() + Content.COUNT_FOR_LOTTO)
        randomLottoList.forEach { (_, lottoNumbers) ->
            println(lottoNumbers)
        }
        println()
    }

    fun statisticsForWinMessage() {
        println(Content.STATISTICS_FOR_LOTTO)
        println(Content.THREE_NUMBER_SAME_WIN + WinCount.THREE_NUMBER.getWinCount() + Content.COUNT_MENTION)
        println(Content.FOUR_NUMBER_SAME_WIN + WinCount.FOUR_NUMBER.getWinCount() + Content.COUNT_MENTION)
        println(Content.FIVE_NUMBER_SAME_WIN + WinCount.FIVE_NUMBER.getWinCount() + Content.COUNT_MENTION)
        println(Content.FIVE_AND_BONUS_NUMBER_SAME_WIN + WinCount.FIVE_NUMBER_AND_BONUS.getWinCount() + Content.COUNT_MENTION)
        println(Content.SIX_NUMBER_SAME_WIN + WinCount.SIX_NUMBER.getWinCount() + Content.COUNT_MENTION)
    }

    fun earnPercentMessage (earnPercent: Double) {
        println(Content.SUM_OF_EARN_PERCENT + earnPercent + Content.LAST_MENTION)
    }
}