package validator

import lotto.LottoConstants.LOTTO_NUMBER_RANGE

class RangeValidator(private val range: IntRange = LOTTO_NUMBER_RANGE) : NumbersValidator {

    override fun validate(value: List<Int>) {
        require(value.all { it in range }) {
            RANGE_ERROR_FORMAT.format(value)
        }
    }

    companion object {
        private val RANGE_ERROR_FORMAT = "로또 번호는 1~45 사이의 값이여야 합니다."
    }
}