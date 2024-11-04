package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Constants
import lotto.constants.Constants.PRICE_INPUT_MSG
import lotto.constants.Constants.WINNING_NUMBERS_INPUT_MSG
import lotto.constants.Constants.BONUS_NUMBER_INPUT_MSG
import lotto.util.Validator
import lotto.util.toIntOrException

class InputView(
    private val validator: Validator = Validator(),
) {
    fun getPriceInput(): Int {
        println(PRICE_INPUT_MSG)
        while (true) {
            try {
                val input = read()
                val price = input.toIntOrException()

                validator.validatePriceRange(price)
                validator.validatePriceRange(price)

                return price
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getWinningNumbersInput(): List<Int> {
        println(WINNING_NUMBERS_INPUT_MSG)
        while (true) {
            try {
                val input = read()
                val winningNumberList = input.split(Constants.DELIMITER)

                val tempWinningNumbers = winningNumberList.map {
                    val value = it.toIntOrException()
                    validator.validateLottoNumberRange(value)
                    value
                }

                return tempWinningNumbers.sorted()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumberInput(): Int {
        println(BONUS_NUMBER_INPUT_MSG)
        while (true) {
            try {
                val input = read()
                val tempBonusNumber = input.toIntOrException()

                validator.validateLottoNumberRange(tempBonusNumber)

                return tempBonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun read(): String = Console.readLine() ?: throw IllegalArgumentException()

    fun close() = Console.close()
}