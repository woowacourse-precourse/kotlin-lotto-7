package lotto.ui

import camp.nextstep.edu.missionutils.Console

object InputView {

    private const val LOTTO_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요."

    fun readLottoAmount(): String {
        println(LOTTO_AMOUNT_INPUT_MESSAGE)
        return Console.readLine()
    }
}