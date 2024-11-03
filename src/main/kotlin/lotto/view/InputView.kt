package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Constants

object InputView {
    // 구입 금액 입력
    fun readPurchaseAmount(): Int {
        println(Constants.MESSAGE_INPUT_PURCHASE_AMOUNT)
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException(Constants.ERROR_INVALID_NUMBER_INPUT)
    }

    // 당첨 번호 입력
    fun readWinningNumbers(): List<Int> {
        println(Constants.MESSAGE_INPUT_WINNING_NUMBERS)
        val input = Console.readLine()
        return input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException(Constants.ERROR_INVALID_NUMBER_INPUT)
        }
    }

    // 보너스 번호 입력
    fun readBonusNumber(): Int {
        println(Constants.MESSAGE_INPUT_BONUS_NUMBER)
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException(Constants.ERROR_INVALID_NUMBER_INPUT)
    }
}
