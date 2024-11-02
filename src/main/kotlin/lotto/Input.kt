package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

class Input {
    var ticket = 0
        get() = field

    fun inputMoney() {
        val input = Console.readLine()
        val money = confirmInteger(input)
        confirmNegativeOrZero(money)
        ticket = confirmDivider(money)
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

    //금액이 0이거나 음수인 경우
    private fun confirmNegativeOrZero(money: Int) {
        if(money <= 0)
            throw IllegalArgumentException("[ERROR] 티켓은 양의 정수만 입력할 수 있습니다.")
    }

    //티켓이 1000원 단위로 나누어 떨어 지지 않는 경우
    private fun confirmDivider(ticket : Int) : Int{
        if(ticket % 1000 != 0){
            throw IllegalArgumentException("[ERROR] 티켓은 1000원 단위로만 입력할 수 있습니다.")
        }
        return ticket / 1000
    }

}