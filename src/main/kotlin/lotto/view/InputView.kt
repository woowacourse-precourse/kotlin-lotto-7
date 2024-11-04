package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.message.InputMessage

object InputView {

    fun askForPurchaseAmount(): String {
        println(InputMessage.INPUT_PURCHASE_AMOUNT.message)
        return Console.readLine()
    }

    fun askWinningNumbers(): String {
        println(InputMessage.INPUT_WINNING_NUMBERS.message)
        return Console.readLine()
    }

    fun askForBonusNumber(): String {
        println(InputMessage.INPUT_BONUS_NUMBERS.message)
        return Console.readLine()
    }
}