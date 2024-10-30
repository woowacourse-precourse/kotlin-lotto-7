package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.data.LottoAmount

object InputView {

    private const val LOTTO_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요."

    fun buildLottoAmount(): LottoAmount {
        try {
            println(LOTTO_AMOUNT_INPUT_MESSAGE)
            return LottoAmount(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return buildLottoAmount()
        }
    }
}