package lotto.domain.entity

import lotto.domain.validator.BonusNumberValidator

class BonusNumber(
    val number: Int,
    winningNumbers: List<Int>,
    validator: BonusNumberValidator = bonusNumberValidator
) {
    init {
        validator.validateBonusNumber(number, winningNumbers)
    }

    companion object {
        private val bonusNumberValidator by lazy { BonusNumberValidator() }
    }
}