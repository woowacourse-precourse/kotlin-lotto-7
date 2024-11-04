package lotto.validator

import lotto.exception.ExceptionCode
import lotto.exception.LottoException

object LottoValidator {
    private const val LOTTO_NUMBER_COUNT = 6
    const val LOTTO_LOWER_BOUND = 1
    const val LOTTO_UPPER_BOUND = 45

    fun validate(input: List<Int>) {
        validateNumberCount(input)
        validateNumericRange(input)
        validateDuplicateNumber(input)
    }

    private fun validateNumberCount(input: List<Int>) {
        if (input.size != LOTTO_NUMBER_COUNT) throw LottoException(ExceptionCode.INVALID_LOTTO_NUMBER_COUNT)
    }

    private fun validateNumericRange(input: List<Int>) {
        input.filter {
            it in LOTTO_LOWER_BOUND..LOTTO_UPPER_BOUND
        }.also { if (it.size != LOTTO_NUMBER_COUNT) throw LottoException(ExceptionCode.OUT_OF_BOUND_LOTTO_NUMBER) }
    }

    private fun validateDuplicateNumber(input: List<Int>) {
        if (input.size != input.distinct().size) {
            throw LottoException(ExceptionCode.DUPLICATE_LOTTO_NUMBER)
        }
    }

}