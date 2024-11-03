package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constant.InputMessage


class InputView {
    fun getMoney(): String {
        InputMessage.MONEY.display()
        return Console.readLine()
    }

    fun getWinningNum(): String {
        InputMessage.WINNING_NUM.display()
        return Console.readLine()
    }

    fun getBonusNum(): String {
        InputMessage.BONUS.display()
        return Console.readLine()
    }
}
