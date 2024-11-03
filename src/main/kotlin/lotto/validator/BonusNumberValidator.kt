package lotto.validator

import lotto.exception.ExceptionCode
import lotto.exception.LottoException
import lotto.validator.LottoValidator.LOTTO_LOWER_BOUND
import lotto.validator.LottoValidator.LOTTO_UPPER_BOUND

object BonusNumberValidator {

    fun validate(input: Int) {
        validateNumericRange(input)
    }

    private fun validateNumericRange(input: Int) {
        if (input !in LOTTO_LOWER_BOUND..LOTTO_UPPER_BOUND) {
            throw LottoException(ExceptionCode.OUT_OF_BOUND_LOTTO_NUMBER)
        }
    }

}