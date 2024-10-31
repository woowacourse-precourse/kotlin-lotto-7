package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputValidator.validateInputIsNumeric

class InputView {
    fun readLottoMoney(): Int {
        println(PROMPT_LOTTO_MONEY)
        val lottoMoney = Console.readLine()
        validateInputIsNumeric(lottoMoney)
        return lottoMoney.toInt()
    }

    companion object {
        const val PROMPT_LOTTO_MONEY = "구입금액을 입력해 주세요."
    }
}
