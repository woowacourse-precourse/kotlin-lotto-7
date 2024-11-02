package lotto.model

import lotto.utils.ErrorFormatter.getErrorMessage
import constant.LOTTO_SIZE
import constant.MAX_LOTTO_NUMBER
import constant.MIN_LOTTO_NUMBER

class WinningLotto(winningLottoInput: String) {
    val winningNumbers: Set<Int>

    init {
        winningNumbers = validateWinningLotto(winningLottoInput)
    }

    private fun validateWinningLotto(input: String): Set<Int> {
        val numbers = input.split(",").map { it.trim() }

        val validatedNumbers = validateWinningLottoNumber(numbers)
        validateWinningLottoLength(validatedNumbers)

        return validatedNumbers
    }

    private fun validateWinningLottoLength(numbers: Set<Int>) {
        require(numbers.size == LOTTO_SIZE) { getErrorMessage(INVALID_WINNING_NUMBERS_SIZE) }
    }

    private fun validateWinningLottoNumber(numbers: List<String>): Set<Int> {
        val validatedNumbers = numbers.map { numberString ->
            val number = requireNotNull(numberString.toIntOrNull()) {
                getErrorMessage(INVALID_WINNING_LOTTO_NUMBER)
            }

            require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
                getErrorMessage(INVALID_WINNING_LOTTO_NUMBER)
            }
            number
        }.toSet()

        return validatedNumbers
    }

    fun addBonusNumber(bonusNumberInput: String) {
        val bonusNumber = validateBonusNumber(bonusNumberInput)
        winningNumbers.plus(bonusNumber)
    }

    private fun validateBonusNumber(bonusNumberInput: String): Int {
        val bonusNumber = requireNotNull(bonusNumberInput.toInt()) {
            getErrorMessage(getErrorMessage(INVALID_BONUS_NUMBER))
        }

        require(bonusNumber >= MIN_LOTTO_NUMBER && bonusNumber <= MAX_LOTTO_NUMBER) {
            getErrorMessage(getErrorMessage(INVALID_BONUS_NUMBER))
        }

        validateNoDuplicateNumber(bonusNumber)

        return bonusNumber
    }

    private fun validateNoDuplicateNumber(bonusNumber : Int) {
        require(!winningNumbers.contains(bonusNumber)) {
            getErrorMessage(INVALID_BONUS_NUMBER_DUPLICATE)
        }
    }

    companion object {
        private const val INVALID_WINNING_NUMBERS_SIZE = "당첨 번호는 ${LOTTO_SIZE}개여야 합니다."
        private const val INVALID_WINNING_LOTTO_NUMBER =
            "당첨 번호는 ${MIN_LOTTO_NUMBER}과 ${MAX_LOTTO_NUMBER}사이 숫자만 가능합니다."
        private const val INVALID_BONUS_NUMBER =
            "보너스 번호는 ${MIN_LOTTO_NUMBER}과 ${MAX_LOTTO_NUMBER}사이 숫자만 가능합니다."
        private const val INVALID_BONUS_NUMBER_DUPLICATE =
            "보너스 번호는 당첨 번호에 있는 숫자와 중복될 수 없습니다."

    }
}