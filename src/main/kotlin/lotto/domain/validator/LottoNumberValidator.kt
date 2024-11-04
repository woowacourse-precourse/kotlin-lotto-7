package lotto.domain.validator

import lotto.common.MAX_LOTTO_NUMBER
import lotto.common.MIN_LOTTO_NUMBER

open class LottoNumberValidator {
    protected fun validateNumberRange(number: Int) {
        require(number <= MAX_LOTTO_NUMBER) { OVER_LOTTO_NUMBER_ERROR_MESSAGE }
        require(number >= MIN_LOTTO_NUMBER) { UNDER_LOTTO_NUMBER_ERROR_MESSAGE }
    }

    companion object {
        private const val OVER_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 45보다 작거나 같아야 합니다."
        private const val UNDER_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1보다 크거나 같아야 합니다."
    }
}