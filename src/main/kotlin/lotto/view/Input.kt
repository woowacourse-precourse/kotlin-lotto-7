package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.util.Constants
import lotto.util.Transformer

object Input {
    fun readWinningNumber(): Lotto {
        Output.printWinningNumberToInput()
        val winningNumber = Console.readLine()
        return Lotto(Transformer().stringToIntList(winningNumber.split(',')))
    }

    fun readBonusNumber(): Int {
        Output.printBonusNumberToInput()
        val bonusNumber = Console.readLine()
        return bonusNumber.toInt()
    }

    fun readMoney(): Int {
        Output.printMoneyToInput()
        val money = Console.readLine()
        return money.toInt()
    }

}