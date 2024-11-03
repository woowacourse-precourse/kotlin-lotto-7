package lotto.domain

import lotto.exception.InvalidInputException
import lotto.util.Constants

// 당첨 번호와 보너스 번호 관리
class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        validateWinningNumbers()
        validateBonusNumber()
    }

    // 당첨 번호 유효성 검증
    private fun validateWinningNumbers() {
        if (winningNumbers.size != Constants.LOTTO_NUMBER_COUNT) {
            throw InvalidInputException(Constants.ERROR_INVALID_WINNING_NUMBERS_SIZE)
        }
        if (winningNumbers.distinct().size != Constants.LOTTO_NUMBER_COUNT) {
            throw InvalidInputException(Constants.ERROR_DUPLICATE_NUMBER)
        }
        if (!winningNumbers.all { it in Constants.LOTTO_NUMBER_MIN..Constants.LOTTO_NUMBER_MAX }) {
            throw InvalidInputException(Constants.ERROR_NUMBER_OUT_OF_RANGE)
        }
    }

    // 보너스 번호 유효성 검증
    private fun validateBonusNumber() {
        if (bonusNumber !in Constants.LOTTO_NUMBER_MIN..Constants.LOTTO_NUMBER_MAX) {
            throw InvalidInputException(Constants.ERROR_NUMBER_OUT_OF_RANGE)
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw InvalidInputException(Constants.ERROR_BONUS_NUMBER_DUPLICATE)
        }
    }

    fun getWinningNumbers(): List<Int> = winningNumbers

    fun getBonusNumber(): Int = bonusNumber
}
