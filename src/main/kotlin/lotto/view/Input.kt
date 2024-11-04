package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constant.Message.INFO_GET_LOTTO_BONUS_NUMBERS
import lotto.constant.Message.INFO_GET_LOTTO_NUMBERS
import lotto.constant.Message.INFO_GET_PURCHASE_AMOUNT
import lotto.constant.Message.TICKET_PRICE
import lotto.validation.InputValidation

class Input {
    private val inputValidation = InputValidation()

    fun getPurchaseAmount(): Int {
        println(INFO_GET_PURCHASE_AMOUNT)
        val value = readLine().let {
            inputValidation.typeInt(it).also { amount ->
                inputValidation.unitOfNumber(amount, TICKET_PRICE)
            }
        }
        println()
        return value
    }

    fun getLottoNumbers(): List<Int> {
        println(INFO_GET_LOTTO_NUMBERS)
        val value = readLine().let {
            inputValidation.lottoNumbers(inputValidation.lottoNumbersDelimiter(it))
        }
        println()
        return value
    }

    fun getLottoBonusNumber(): Int {
        println(INFO_GET_LOTTO_BONUS_NUMBERS)
        val value = readLine().let {
            inputValidation.typeInt(it).also { number ->
                inputValidation.lottoNumberRange(number)
            }
        }
        println()
        return value
    }

    private fun readLine(): String = Console.readLine()
}