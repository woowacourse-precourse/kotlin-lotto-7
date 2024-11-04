package lotto.util.validator

import lotto.util.constant.ErrorMessages
import lotto.util.constant.LottoRules

object BonusNumberValidator {
    fun getValidatedBonusNumber(bonusNumberInput: String, winningNumbers: List<Int>): Int {
        validateIsNumeric(bonusNumberInput)

        val bonusNumber = bonusNumberInput.toInt()
        validateIsInRange(bonusNumber)
        validateUniqueness(bonusNumber, winningNumbers)

        return bonusNumber
    }

    private fun validateIsNumeric(input: String) {
        require(input.toIntOrNull() != null) { ErrorMessages.BONUS_NUMBER_NUMERIC }
    }

    private fun validateIsInRange(input: Int) {
        require(input in LottoRules.LOTTO_NUMBER_RANGE) { ErrorMessages.BONUS_NUMBER_RANGE }
    }

    private fun validateUniqueness(bonusNumber: Int, numbers: List<Int>) {
        require(bonusNumber !in numbers) { ErrorMessages.BONUS_NUMBER_UNIQUE }
    }
}