package lotto.domain.entity

import lotto.domain.validator.BonusLottoNumberValidator

class BonusNumber(
    val number: Int,
    winningNumbers: List<Int>,
    validator: BonusLottoNumberValidator = bonusNumberValidator
) {
    init {
        validator.validateBonusNumber(number, winningNumbers)
    }

    companion object {
        private val bonusNumberValidator by lazy { BonusLottoNumberValidator() }
    }
}