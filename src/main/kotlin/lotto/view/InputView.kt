package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.InputMessage

class InputView {
    fun readPrice(): String {
        println(InputMessage.PRICE)
        return Console.readLine()
    }

    fun readWinningNumber(): String {
        println()
        println(InputMessage.WINNING_NUMBER)
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println()
        println(InputMessage.BONUS_NUMBER)
        return Console.readLine()
    }
}