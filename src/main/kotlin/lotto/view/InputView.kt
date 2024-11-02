package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val GET_PURCHASE_MONEY_SCRIPT = "구입금액을 입력해주세요."
    private const val GET_WINNING_NUMBERS_SCRIPT = "당첨 번호를 입력해 주세요."

    fun getPurchaseMoneyInput(): String {
        println(GET_PURCHASE_MONEY_SCRIPT)
        return Console.readLine()
    }

    fun getWinningLottoInput() : String {
        println(GET_WINNING_NUMBERS_SCRIPT)
        return Console.readLine()
    }
}

