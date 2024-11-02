package lotto.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun readWinningNumber():Int{
        Output.printMoneyToInput()
        val money = Console.readLine()
        return money.toInt()
    }

    fun readBonusNumber(){

    }

    fun readMoney(){

    }

}