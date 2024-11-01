package lotto.model

import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER

class BonusNumber {
    private var bonusNumber: Int? = null

    fun getBonusNumber(): Int = bonusNumber ?: 0

    fun setBonusNumber(rawBonusNumber: String, winningNumbers: List<Int>) {
        validateBonusNumber(rawBonusNumber, winningNumbers)

        bonusNumber = rawBonusNumber.trim().toInt()
    }

    private fun validateBonusNumber(rawBonusNumber: String, winningNumbers: List<Int>) {
        require(rawBonusNumber.toIntOrNull() != null) { BONUS_NUMBER_TYPE_MESSAGE }
        require(!winningNumbers.contains(rawBonusNumber.toInt())) { BONUS_NUMBER_DUPLICATE_MESSAGE }
        require(rawBonusNumber.toInt() in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) { BONUS_NUMBER_RANGE_MESSAGE }
    }

    companion object {
        const val BONUS_NUMBER_TYPE_MESSAGE = "당첨 번호는 숫자여야 합니다."
        const val BONUS_NUMBER_DUPLICATE_MESSAGE = "보너스 번호는 당첨 번호에 겹치는 번호가 없어야 합니다."
        const val BONUS_NUMBER_RANGE_MESSAGE = "당첨 번호는 1~45 사이의 숫자여야 합니다."
    }
}