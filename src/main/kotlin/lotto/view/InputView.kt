package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private fun getInput(message: String): String {
        println(message)
        val input = Console.readLine()
        return input
    }

    fun close() = Console.close()

    fun getPurchaseAmount(): String = getInput(PURCHASE_AMOUNT_INPUT)
    fun getWinningNumber(): String = getInput(WINNING_NUMBER_INPUT)
    fun getBonusNumber(): String = getInput(BONUS_NUMBER_INPUT)

    companion object {
        const val PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요."
        const val WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요."
        const val BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요."
    }
}