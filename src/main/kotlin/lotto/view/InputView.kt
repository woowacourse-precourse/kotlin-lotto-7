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
        require(lottoAmount.toIntOrNull() != null) { Constants.ERROR_AMOUNT_NOT_NUMBER }
        val amount = lottoAmount.toInt()
        require(amount > 0) { Constants.ERROR_AMOUNT_NOT_POSITIVE }
        require(amount % 1000 == 0) { Constants.ERROR_AMOUNT_NOT_DIVIDE_BY_1000 }
    }
    }
}