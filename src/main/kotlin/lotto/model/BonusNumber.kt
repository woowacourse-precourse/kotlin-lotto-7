package lotto.model

import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.ExceptionConstants.ERROR_MESSAGE_BONUS_NUMBER_DUPLICATE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_BONUS_NUMBER_RANGE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_BONUS_NUMBER_TYPE

class BonusNumber {
    private var bonusNumber: Int? = null

    fun getBonusNumber(): Int = bonusNumber ?: 0

    fun setBonusNumber(rawBonusNumber: String, winningNumbers: List<Int>) {
        validateBonusNumber(rawBonusNumber, winningNumbers)

        bonusNumber = rawBonusNumber.trim().toInt()
    }

    private fun validateBonusNumber(rawBonusNumber: String, winningNumbers: List<Int>) {
        require(rawBonusNumber.toIntOrNull() != null) { ERROR_MESSAGE_BONUS_NUMBER_TYPE }
        require(!winningNumbers.contains(rawBonusNumber.toInt())) { ERROR_MESSAGE_BONUS_NUMBER_DUPLICATE }
        require(rawBonusNumber.toInt() in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) { ERROR_MESSAGE_BONUS_NUMBER_RANGE }
    }
}