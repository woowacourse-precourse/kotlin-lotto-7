package lotto.utils

import camp.nextstep.edu.missionutils.Console

object InputManager {

    private const val INPUT_PURCHASE_MONEY_TITLE = "구입금액을 입력해 주세요."
    /**
     * 로또를 구입할 금액을 입력 받는다.
     * @return 로또 구입 금액
     */
    fun getMoney(): Int {
        println(INPUT_PURCHASE_MONEY_TITLE)
        val input = Console.readLine()
        Console.close()
        return input.toMoney()
    }

    private fun String.toMoney(): Int {
        return trim().toInt()
    }

    private const val INPUT_WINNING_NUMBERS_TITLE = "당첨 번호를 입력해 주세요."
    /**
     * 로또 당첨 번호를 입력 받는다. 쉼표(,)를 기준으로 구분한다.
     * @return 로또 당첨 번호 세트
     */
    fun getWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBERS_TITLE)
        val input = Console.readLine()
        Console.close()
        return input.toWinningNumbers()
    }

    private const val INPUT_WINNING_NUMBERS_SEPARATOR = ","
    private fun String.toWinningNumbers(): List<Int> {
        return split(INPUT_WINNING_NUMBERS_SEPARATOR).map { toInt() }
    }

    private const val INPUT_BONUS_NUMBER_TITLE = "보너스 번호를 입력해 주세요."
    /**
     * 로또 당첨 보너스 번호를 입력 받는다.
     * @return 보너스 번호
     */
    fun getBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER_TITLE)
        val input = Console.readLine()
        Console.close()
        return input.toBonusNumber()
    }

    private fun String.toBonusNumber(): Int {
        return trim().toInt()
    }

}

