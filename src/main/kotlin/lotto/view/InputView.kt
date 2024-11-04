package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getPurchasePrice(): String {
        println(ASK_PURCHASE_PRICE_MSG)
        return Console.readLine()
    }

    fun getWinningNumbers(): String {
        println(ASK_WINNING_NUMBERS_MSG)
        return Console.readLine()
    }

    fun getBonusNumber(): String {
        println(ASK_BONUS_NUMBER_MSG)
        return Console.readLine()
    }

    companion object {
        val ASK_PURCHASE_PRICE_MSG = "구입금액을 입력해 주세요."
        val ASK_WINNING_NUMBERS_MSG = "당첨 번호를 입력해 주세요."
        val ASK_BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요."
    }
}