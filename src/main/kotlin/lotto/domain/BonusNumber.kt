package lotto.domain

import lotto.constants.ErrorConstant

class BonusNumber(private val number: Int, private val winningNumber: Lotto) {
    init {
        require(number in 1..45) { ErrorConstant.ERROR_BONUS_NUMBER_OUT_OF_RANGE }
        require(!winningNumber.getNumber().contains(number)) { ErrorConstant.ERROR_BONUS_NUMBER_DUPLICATED }
    }
}