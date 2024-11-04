package view

import camp.nextstep.edu.missionutils.Console
import values.Content

class inputMessage {
    fun moneyForLotto(): String {
        println(Content.MONEY_FOR_LOTTO)
        return Console.readLine()
    }

    fun winNumberForLotto(): String {
        println(Content.WIN_NUMBER_FOR_LOTTO)
        return Console.readLine()
    }

    fun bonusNumberForLotto(): String {
        println(Content.BONUS_NUMBER_FOR_LOTTO)
        return Console.readLine()
    }
}