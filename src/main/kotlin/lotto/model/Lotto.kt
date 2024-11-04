package lotto.model

import lotto.util.ErrorMessage
import lotto.util.Validator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.LOTTO_NUMBERS_MUST_SIX_LETTERS.getMessage() }
        require(Validator.isUniqueNumbers(numbers)) { ErrorMessage.LOTTO_NUMBERS_MUST_UNIQUE.getMessage() }
        require(Validator.validateNumberLimit(numbers)) { ErrorMessage.LOTTO_NUMBER_EXCEEDS_MAX.getMessage() }
    }

    fun getNumbers(): List<Int> = numbers

    fun getSortedNumbers(): List<Int> = numbers.sorted()
}

fun List<Lotto>.toViewData(): List<List<Int>> = this.map { it.getNumbers() }
