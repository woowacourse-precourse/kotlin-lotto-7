package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputViewImpl : InputView {

    override fun readPurchaseAmount(): String {
        println(PURCHASE_AMOUNT_PROMPT)
        return Console.readLine()
    }

    override fun readWinningNumbers(): String {
        println(WINNING_NUMBERS_PROMPT)
        return Console.readLine()
    }

    override fun readBonusNumber(): String {
        println(BONUS_NUMBER_PROMPT)
        return Console.readLine()
    }

    companion object {
        const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
        const val WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요."
        const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
    }
}