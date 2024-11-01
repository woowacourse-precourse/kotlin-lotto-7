package lotto.viewm

import camp.nextstep.edu.missionutils.Console
import lotto.constants.INPUT_PURCHASE_AMOUNT

object InputView {
    fun inputPurchaseAmount(): String {
        println(INPUT_PURCHASE_AMOUNT)
        return Console.readLine()
    }
}