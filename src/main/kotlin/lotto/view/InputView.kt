package lotto.viewm

import camp.nextstep.edu.missionutils.Console
import lotto.constants.*

object InputView {
    fun inputPurchaseAmount(): String {
        println(INPUT_PURCHASE_AMOUNT)
        return Console.readLine()
    }

    fun inputWinNum(): String {
        println(INPUT_WINNING_NUMBER)
        return Console.readLine()
    }
}