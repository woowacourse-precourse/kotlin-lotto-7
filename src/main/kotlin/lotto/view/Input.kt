package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Constants

class Input {
    fun readWinningNumber():List<String>{
        Output.printWinningNumberToInput()
        val winningNumber = Console.readLine()
        return winningNumber.split(',')
    }

    fun readBonusNumber(){

    }

    fun readMoney():Int{
        Output.printMoneyToInput()
        val money = Console.readLine()
        return money.toInt()
    }

}