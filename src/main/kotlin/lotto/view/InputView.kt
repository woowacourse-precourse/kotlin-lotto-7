package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val GET_PURCHASE_MONEY = "구입금액을 입력해주세요."

    fun getPurchaseMoney(): String {
        println(GET_PURCHASE_MONEY)
        return Console.readLine()
    }
}

