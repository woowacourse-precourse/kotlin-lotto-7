package view

import values.Content

class outputMessage {
    fun randomLottoList(count: Int, randomNumberList: MutableMap<Int, List<Int>>) {
        println(count.toString() + Content.COUNT_FOR_LOTTO)
        println(randomNumberList)
    }

    fun statisticsForWinMessage() {
        println(Content.STATISTICS_FOR_LOTTO)
        println(Content.THREE_NUMBER_SAME_WIN + Content.COUNT_MENTION)
        println(Content.FOUR_NUMBER_SAME_WIN + Content.COUNT_MENTION)
        println(Content.FIVE_NUMBER_SAME_WIN + Content.COUNT_MENTION)
        println(Content.FIVE_AND_BONUS_NUMBER_SAME_WIN + Content.COUNT_MENTION)
        println(Content.SIX_NUMBER_SAME_WIN + Content.COUNT_MENTION)
    }

    fun earnPercentMessage (earnPercent: Double) {
        println(Content.SUM_OF_EARN_PERCENT + earnPercent + Content.LAST_MENTION)
    }
}