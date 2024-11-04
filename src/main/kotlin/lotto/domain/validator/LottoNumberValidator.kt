package lotto.domain.validator

import lotto.common.MAX_LOTTO_NUMBER
import lotto.common.MIN_LOTTO_NUMBER

open class LottoNumberValidator {
    protected fun validateNumberRange(number: Int) {
        require(number <= MAX_LOTTO_NUMBER) { LOTTO_NUMBER_RANGE_ERROR_MESSAGE }
        require(number >= MIN_LOTTO_NUMBER) { LOTTO_NUMBER_RANGE_ERROR_MESSAGE }
    }

    companion object {
        private const val LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}