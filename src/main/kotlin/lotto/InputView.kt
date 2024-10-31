package lotto

import camp.nextstep.edu.missionutils.Console

class InputView(private val validator: InputValidator) {

    fun getPurchaseAmount(): String {
        println(PURCHASE_AMOUNT_PROMPT)
        val input = Console.readLine()
        return validator.validatePurchaseAmount(input)
    }

    fun getWinningNumbers(): List<Int> {
        println(WINNING_NUMBERS_PROMPT)
        val input = Console.readLine()
        return validator.validateWinningNumbers(input)
    }

    fun getBonusNumber(): Int {
        println(BONUS_NUMBER_PROMPT)
        val input = Console.readLine()
        return validator.validateBonusNumber(input)
    }

    companion object {
        const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
        const val WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요. 번호는 쉼표(,)로 구분합니다."
        const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
    }
}