package lotto.model

import lotto.util.ErrorMessage

@JvmInline
value class BonusNumber(val number: Int) {
    constructor(number: Int, lotto: Lotto) : this(number) {
        validateBonusNumber(number, lotto)
    }

    private fun validateBonusNumber(number: Int, lotto: Lotto) {
        validateDuplicateBonusNumber(number, lotto)
        validateBonusNumberRange(number)
    }

    private fun validateDuplicateBonusNumber(number: Int, lotto: Lotto) {
        require(!lotto.contains(LottoNumber(number))) {
            ErrorMessage.BONUS_DUPLICATE.getMessage()
        }
    }

    private fun validateBonusNumberRange(number: Int) {
        require(number in MIN_BONUS_NUMBER..MAX_BONUS_NUMBER) {
            ErrorMessage.BONUS_RANGE.getMessage()
        }
    }

    companion object {
        private const val MIN_BONUS_NUMBER = 1
        private const val MAX_BONUS_NUMBER = 45
    }
}
