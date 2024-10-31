package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readLottoMoney(): Int {
        println(PROMPT_LOTTO_MONEY)
        val lottoMoney = Console.readLine().toInt()
        return lottoMoney
    }

    companion object {
        const val PROMPT_LOTTO_MONEY = "구입금액을 입력해 주세요."
    }
}
