package lotto.data

import lotto.constants.Error.ERROR_BONUS_NUMBER_DUPLICATE
import lotto.constants.Error.ERROR_BONUS_NUMBER_NOT_INTEGER
import lotto.constants.Error.ERROR_BONUS_NUMBER_OUT_OF_RANGE

class BonusNumber(private val bonusNumber: String, winningNumbers: List<Int>) {
    init {
        require(bonusNumber.toIntOrNull() != null) { ERROR_BONUS_NUMBER_NOT_INTEGER }
        require(bonusNumber.toInt() in 1..45) { ERROR_BONUS_NUMBER_OUT_OF_RANGE }
        require(winningNumbers.all { it != bonusNumber.toInt() }) { ERROR_BONUS_NUMBER_DUPLICATE }
    }

    fun getNumber() = bonusNumber.toInt()
}