package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputPurchaseMoney(): Int {
        println(INPUT_PURCHASE_MONEY_MESSAGE)
        val money = Console.readLine().toInt()
        return money
    }

    fun inputWinningNumber(): List<Int> {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        val winningNumbers = Console.readLine().split(NUMBER_DELIMITER)
        return winningNumbers.map { it.toInt() }
    }

    private const val INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."

    private const val NUMBER_DELIMITER = ','
}