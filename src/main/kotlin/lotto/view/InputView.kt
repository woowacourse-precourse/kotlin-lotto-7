package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.message.InputMessage

object InputView {

    fun askForPrice(): String {
        println(InputMessage.INPUT_PURCHASE_PRICE.message)
        return Console.readLine()
    }

    fun askWinningNumbers(): String {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine()
    }

    fun askForBonusNumber(): String {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }
}