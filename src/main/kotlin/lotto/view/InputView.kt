package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.utils.ErrorMessage
import lotto.utils.InputMessage

object InputView {
    fun inputLottoPrice(): Int {
        while (true) {
            try {
                println(InputMessage.INPUT_PRICE.getMessage())
                val price = validateLottoPrice(readLine())
                return price
            } catch (e: IllegalArgumentException) {
                println(e.message ?: ErrorMessage.UNKNOWN_ERROR.getMessage())
                println()
            }
        }
    }

    private fun validateLottoPrice(inputPrice: String): Int {
        try {
            val price = inputPrice.toInt()

            if (price % 1000 != 0) {
                throw IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage())
            }
            return price
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage())
        }
    }
}