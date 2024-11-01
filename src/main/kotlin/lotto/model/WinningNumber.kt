package lotto.model

import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.LOTTO_NUMBER_SIZE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_WINNING_NUMBER_DUPLICATE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_WINNING_NUMBER_RANGE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_WINNING_NUMBER_SIZE
import lotto.util.ExceptionConstants.ERROR_MESSAGE_WINNING_NUMBER_TYPE

class WinningNumber(private var winningNumbers: List<Int> = emptyList()) {

    fun getWinningNumbers(): List<Int> = winningNumbers

    fun setWinningNumbers(rawWinningNumbers: String) {
        validateWinningNumbers(rawWinningNumbers)

        winningNumbers = rawWinningNumbers.split(",").map { it.trim().toInt() }
    }

    private fun validateWinningNumbers(rawWinningNumbers: String) {
        val separatedRawWinningNumbers = rawWinningNumbers.split(",").map { it.trim() }
        require(separatedRawWinningNumbers.size == LOTTO_NUMBER_SIZE) { ERROR_MESSAGE_WINNING_NUMBER_SIZE }
        require(separatedRawWinningNumbers.all { it.toIntOrNull() != null }) { ERROR_MESSAGE_WINNING_NUMBER_TYPE }
        require(separatedRawWinningNumbers.distinct().size == separatedRawWinningNumbers.size) { ERROR_MESSAGE_WINNING_NUMBER_DUPLICATE }
        require(separatedRawWinningNumbers.all { it.toInt() in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { ERROR_MESSAGE_WINNING_NUMBER_RANGE }
    }
}