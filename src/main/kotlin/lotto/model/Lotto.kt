package lotto.model

import lotto.util.ErrorMessage
import lotto.util.validator.LottoValidator

class Lotto(private val numbers: List<Int>) {
    init {
        require(LottoValidator.isNumbersLengthSix(numbers)) { ErrorMessage.LOTTO_NUMBERS_MUST_SIX_LETTERS.getMessage() }
        require(LottoValidator.isNumbersUnique(numbers)) { ErrorMessage.LOTTO_NUMBERS_MUST_UNIQUE.getMessage() }
        require(LottoValidator.isMaximumNumberExceeded(numbers)) { ErrorMessage.LOTTO_NUMBER_EXCEEDS_MAX.getMessage() }
    }

    fun getNumbers(): List<Int> = numbers

    fun getSortedNumbers(): List<Int> = numbers.sorted()
}

fun List<Lotto>.toViewData(): List<List<Int>> = this.map { it.getNumbers() }
