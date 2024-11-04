package View

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getMoney(): String? {
        OutputView.printMoneyMessage()
        return Console.readLine()
    }
}