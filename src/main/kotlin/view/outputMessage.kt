package view

import values.Content

class outputMessage {
    fun printLottoList(count: Int, randomLottoList: MutableMap<Int, List<Int>>) {
        println(count.toString() + Content.COUNT_FOR_LOTTO)
        println(randomLottoList)
    }

    fun statisticsForWinMessage(winForLottoList: MutableList<Int>) {
        println(Content.STATISTICS_FOR_LOTTO)
        println(Content.THREE_NUMBER_SAME_WIN + winForLottoList[0] + Content.COUNT_MENTION)
        println(Content.FOUR_NUMBER_SAME_WIN + winForLottoList[1] + Content.COUNT_MENTION)
        println(Content.FIVE_NUMBER_SAME_WIN + winForLottoList[2] + Content.COUNT_MENTION)
        println(Content.FIVE_AND_BONUS_NUMBER_SAME_WIN + winForLottoList[3] + Content.COUNT_MENTION)
        println(Content.SIX_NUMBER_SAME_WIN + winForLottoList[4] + Content.COUNT_MENTION)
    }

    fun earnPercentMessage (earnPercent: Double) {
        println(Content.SUM_OF_EARN_PERCENT + earnPercent + Content.LAST_MENTION)
    }
}