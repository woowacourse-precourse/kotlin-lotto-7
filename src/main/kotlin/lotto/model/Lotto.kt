package lotto.model

import lotto.util.Constants.EXCEPTION_PREFIX
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.LOTTO_NUMBER_SIZE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INVALID_LOTTO_SIZE_MESSAGE }
        require(numbers.distinct().size == numbers.size) { DUPLICATE_LOTTO_NUMBERS_MESSAGE }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { INVALID_LOTTO_RANGE_MESSAGE }
    }

    fun getLottoNumbers(): List<Int> = numbers.sorted()

    companion object {
        const val INVALID_LOTTO_SIZE_MESSAGE = "${EXCEPTION_PREFIX}로또 번호는 6개여야 합니다."
        const val DUPLICATE_LOTTO_NUMBERS_MESSAGE = "${EXCEPTION_PREFIX}중복된 로또 번호가 없어야 합니다."
        const val INVALID_LOTTO_RANGE_MESSAGE = "${EXCEPTION_PREFIX}로또 번호는 1~45 사이의 숫자여야 합니다."
    }
}