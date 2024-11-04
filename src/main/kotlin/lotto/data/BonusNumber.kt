package lotto.data

import lotto.constants.Error.ERROR_BONUS_NUMBER_DUPLICATE
import lotto.constants.Error.ERROR_BONUS_NUMBER_NOT_INTEGER
import lotto.constants.Error.ERROR_BONUS_NUMBER_OUT_OF_RANGE

class BonusNumber(private val bonusNumber: String, private val winningNumbers: List<Int>) {
    init {
        validateBonusNumber()
    }

    private fun validateBonusNumber() {
        val number = bonusNumber.toIntOrNull() ?: throw NumberFormatException(ERROR_BONUS_NUMBER_NOT_INTEGER)
        require(number in 1..45) { ERROR_BONUS_NUMBER_OUT_OF_RANGE }
        require(winningNumbers.all { it != number }) { ERROR_BONUS_NUMBER_DUPLICATE }
    }

    fun getNumber() = bonusNumber.toInt()
}