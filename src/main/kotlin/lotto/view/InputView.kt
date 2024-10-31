package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Constants

class InputView {
    fun getLottoAmount(): Int {
        while (true) {
            println(Constants.INPUT_BUY_AMOUNT_MESSAGE)
            val input = Console.readLine()
            try {
                validateLottoAmount(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
    private fun validateLottoAmount(lottoAmount: String) {
    }
}