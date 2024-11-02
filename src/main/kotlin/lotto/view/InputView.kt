package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputPurchaseMoney(): Int {
        println(INPUT_PURCHASE_MONEY_MESSAGE)
        val money = Console.readLine().toInt()
        return money
    }

    private const val INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."
}