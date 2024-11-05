package lotto.validation

import lotto.constant.Error.LOTTO_DUPLICATE
import lotto.constant.Error.LOTTO_RANGE
import lotto.constant.Error.LOTTO_SIZE
import lotto.constant.Error.NOT_NUMBER
import lotto.constant.Error.UNIT_OF_PRICE
import lotto.constant.Message.COMMA

class InputValidation {
    fun typeInt(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException(NOT_NUMBER.format(input))
    }

    fun unitOfPrice(price: Int, unit: Int): Int {
        if (price % unit == 0)
            return price
        throw IllegalArgumentException(UNIT_OF_PRICE.format(unit))
    }

    fun lottoNumbersDelimiter(input: String): List<Int> {
        return input.split(COMMA).map {
            typeInt(it)
        }
    }

    fun lottoNumberRange(number: Int): Int {
        require(number in 1..45) { LOTTO_RANGE }
        return number
    }

    private fun lottoNumbersSize(numbers: List<Int>): List<Int> {
        require(numbers.size == 6) { LOTTO_SIZE }
        return numbers
    }

    fun lottoNumbersNotDuplicate(numbers: List<Int>): List<Int> {
        require(numbers.toSet().size == numbers.size) { LOTTO_DUPLICATE }
        return numbers
    }

    fun lottoNumbers(numbers: List<Int>): List<Int> {
        return numbers.map {
            lottoNumberRange(it)
        }.also {
            lottoNumbersSize(it)
            lottoNumbersNotDuplicate(it)
        }
    }
}