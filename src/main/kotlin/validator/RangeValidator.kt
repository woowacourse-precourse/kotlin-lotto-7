package validator

import lotto.LottoConstants.LOTTO_NUMBER_RANGE
import lotto.LottoConstants.LOTTO_NUMBER_SIZE

class RangeValidator(private val range: IntRange = LOTTO_NUMBER_RANGE) : NumbersValidator {

    override fun validate(value: List<Int>) {
        require(value.all { it in range }) {
            RANGE_ERROR_FORMAT.format(value)
        }
        require(value.size == LOTTO_NUMBER_SIZE) {
            LOTTO_COUNT_ERROR
        }
    }

    companion object {
        val RANGE_ERROR_FORMAT = "로또 번호는 1~45 사이의 값이여야 합니다."
        val LOTTO_COUNT_ERROR = "로또는 6개를 선택해야 됩니다."
    }
}