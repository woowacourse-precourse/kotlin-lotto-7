package lotto.view

import camp.nextstep.edu.missionutils.Console

object Input {
    fun amount(): String {
        val money = Console.readLine()
        return money
    }

    fun winNumber(): String {
        val numbers = Console.readLine()
        return numbers
    }

    fun bonusNUmber(): Int {
        val bonus = Console.readLine().toInt()
        return bonus
    }
}