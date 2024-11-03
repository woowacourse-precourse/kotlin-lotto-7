package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getMoney(): String {
        println(message.MONEY)
        return Console.readLine()
    }

    fun getWinningNumber(): String {
        println(message.WINNING)
        return Console.readLine().replace(" ", "")
    }

    fun getBonusNumber(): String {
        println()
        println(message.BONUS)
        return Console.readLine()
    }
}