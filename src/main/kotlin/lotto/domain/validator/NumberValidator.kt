package lotto.domain.validator

import lotto.common.MAX_LOTTO_NUMBER
import lotto.common.MIN_LOTTO_NUMBER

open class NumberValidator {
    protected fun validateNumberRange(number: Int) {
        require(number <= MAX_LOTTO_NUMBER) { "[ERROR] 보너스 번호는 45보다 작거나 같아야 합니다." }
        require(number >= MIN_LOTTO_NUMBER) { "[ERROR] 보너스 번호는 1보다 크거나 같아야 합니다." }
    }
}