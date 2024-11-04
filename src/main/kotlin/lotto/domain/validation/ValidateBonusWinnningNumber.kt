package lotto.domain.validation

import lotto.domain.exception.ExceptionMessages
import lotto.domain.model.Lotto

fun validateBonusWinningNumber(bonusWinningNumber: Int, winningNumbers: List<Int>) {
    require(bonusWinningNumber in Lotto.VALID_LOTTO_NUMBER_RANGE) {
        ExceptionMessages.NUMBER_OUT_OF_VALID_LOTTO_RANGE_EXISTS
    }
    require(bonusWinningNumber !in winningNumbers) { ExceptionMessages.DUPLICATE_BONUS_WINNING_NUMBER }
}
