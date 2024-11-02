package lotto.model

import lotto.utils.ErrorFormatter.getErrorMessage

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
            val number = numberString.toIntOrNull()
                ?: throw IllegalArgumentException(getErrorMessage(INVALID_WINNING_LOTTO_NUMBER))
            require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
                getErrorMessage(INVALID_WINNING_LOTTO_NUMBER)
            }
            number
        }.toSet()

        return validatedNumbers
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val INVALID_WINNING_NUMBERS_SIZE = "당첨 번호는 ${LOTTO_SIZE}개여야 합니다."
        private const val INVALID_WINNING_LOTTO_NUMBER =
            "당첨 번호는 ${MIN_LOTTO_NUMBER}과 ${MAX_LOTTO_NUMBER}사이만 가능합니다."
    }
}