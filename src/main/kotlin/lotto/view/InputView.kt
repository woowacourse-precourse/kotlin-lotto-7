package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.message.InputMessage

object InputView {

    fun askForPrice(): String {
        println(InputMessage.INPUT_PURCHASE_PRICE.message)
        return Console.readLine()
    }
}