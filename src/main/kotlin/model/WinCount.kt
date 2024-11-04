package model

import values.Content

enum class WinCount {
    THREE_NUMBER, FOUR_NUMBER, FIVE_NUMBER, FIVE_NUMBER_AND_BONUS, SIX_NUMBER;

    private var count = Content.MIN_COUNT

    fun increse() {
        count++
    }

    fun getWinCount(): Int {
        return count
    }
}