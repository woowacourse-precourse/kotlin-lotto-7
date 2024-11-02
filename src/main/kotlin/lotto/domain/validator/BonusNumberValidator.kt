package lotto.domain.validator

class BonusNumberValidator : NumberValidator() {
    fun validateBonusNumber(bonusNumber: Int, numbers: List<Int>) {
        validateNumberRange(bonusNumber)
        require(numbers.contains(bonusNumber).not()) { ERROR_DUPLICATE_WINNING_NUMBER }
    }

    companion object {
        private const val ERROR_DUPLICATE_WINNING_NUMBER = "[ERROR] 보너스 번호는 로또 번호들과 중복되면 안됩니다."
    }
}