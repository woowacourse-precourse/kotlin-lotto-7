package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

class Input {
    var ticket = 0
        get() = field

    fun inputMoney() {
        val input = Console.readLine()
        val money = confirmInteger(input)
    }

    //숫자가 아닌 경우
    private fun confirmInteger(money: String) : Int{
        val intMoney : Int
        try {
            intMoney = money.toInt()
        }catch (e : NumberFormatException){
            throw IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.")
        }
        return intMoney
    }

}