package lotto.model

import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.LOTTO_NUMBER_SIZE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_LOTTO_NUMBER_RANGE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_LOTTO_NUMBER_SIZE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { ERROR_MESSAGE_LOTTO_NUMBER_SIZE }
        require(numbers.distinct().size == numbers.size) { ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATE }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { ERROR_MESSAGE_LOTTO_NUMBER_RANGE }
    }

    fun getLottoNumbers(): List<Int> = numbers.sorted()
}