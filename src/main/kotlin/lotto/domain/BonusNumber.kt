package lotto.domain

import lotto.constants.ErrorConstant

class BonusNumber(private val number: Int) {
    init {
        require(number in 1..45) { ErrorConstant.ERROR_BONUS_NUMBER_OUT_OF_RANGE }
    }
}