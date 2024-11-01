package lotto.model

import lotto.util.Constants.EXCEPTION_PREFIX
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.LOTTO_NUMBER_SIZE

class WinningNumber(private var winningNumbers: List<Int> = emptyList()) {

    fun getWinningNumbers(): List<Int> = winningNumbers

    fun setWinningNumbers(rawWinningNumbers: String) {
        validateWinningNumbers(rawWinningNumbers)

        winningNumbers = rawWinningNumbers.split(",").map { it.trim().toInt() }
    }

    private fun validateWinningNumbers(rawWinningNumbers: String) {
        val separatedRawWinningNumbers = rawWinningNumbers.split(",").map { it.trim() }
        require(separatedRawWinningNumbers.size == LOTTO_NUMBER_SIZE) { NUMBER_SIZE_MESSAGE }
        require(separatedRawWinningNumbers.all { it.toIntOrNull() != null }) { NUMBER_TYPE_MESSAGE }
        require(separatedRawWinningNumbers.distinct().size == separatedRawWinningNumbers.size) { NUMBER_DUPLICATE_MESSAGE }
        require(separatedRawWinningNumbers.all { it.toInt() in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { NUMBER_RANGE_MESSAGE }
    }

    companion object {
        const val NUMBER_SIZE_MESSAGE = "${EXCEPTION_PREFIX}당첨 번호는 6개여야 합니다."
        const val NUMBER_TYPE_MESSAGE = "${EXCEPTION_PREFIX}당첨 번호는 숫자여야 합니다."
        const val NUMBER_DUPLICATE_MESSAGE = "${EXCEPTION_PREFIX}중복된 당첨 번호가 없어야 합니다."
        const val NUMBER_RANGE_MESSAGE = "${EXCEPTION_PREFIX}당첨 번호는 1~45 사이의 숫자여야 합니다."
    }
}