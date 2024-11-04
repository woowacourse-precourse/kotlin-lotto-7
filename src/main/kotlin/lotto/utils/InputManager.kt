package lotto.utils

import camp.nextstep.edu.missionutils.Console

object InputManager {

    private const val INPUT_PURCHASE_MONEY_TITLE = "구입금액을 입력해 주세요."
    /**
     * 로또를 구입할 금액을 입력받는다.
     * @return 로또 구입 금액
     */
    fun getMoney(): Int {
        println(INPUT_PURCHASE_MONEY_TITLE)
        val input = Console.readLine()
        return input.toMoney()
    }

    private fun String.toMoney(): Int {
        return trim().toInt()
    }

}