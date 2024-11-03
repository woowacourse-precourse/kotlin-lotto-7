package lotto

import camp.nextstep.edu.missionutils.Console

class InputView() {

    fun getPurchaseAmount(): String {
        println(PURCHASE_AMOUNT_PROMPT)
        return Console.readLine()
    }

    fun getWinningNumbers(): String {
        println(WINNING_NUMBERS_PROMPT)
        return Console.readLine()

    }

    fun getBonusNumber(): String {
        println(BONUS_NUMBER_PROMPT)
        return Console.readLine()
    }

    companion object {
        const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
        const val WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요. 번호는 쉼표(,)로 구분합니다."
        const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
    }
}