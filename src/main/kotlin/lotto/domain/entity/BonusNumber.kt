package lotto.domain.entity

import lotto.domain.validator.BonusLottoNumberValidator

class BonusNumber(
    val number: Int,
    winningNumbers: WinningNumbers,
    validator: BonusLottoNumberValidator = bonusNumberValidator
) {
    init {
        validator.validateBonusNumber(number, winningNumbers.getNumbers())
    }

    companion object {
        private val bonusNumberValidator by lazy { BonusLottoNumberValidator() }
    }
}