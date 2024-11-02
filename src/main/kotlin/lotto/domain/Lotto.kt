package lotto.domain

import lotto.constants.ErrorConstants.ERROR_NUMBERS_COUNT
import lotto.constants.ErrorConstants.ERROR_NUMBERS_DUPLICATE
import lotto.constants.ErrorConstants.ERROR_NUMBER_RANGE
import lotto.constants.LottoConstants.LOTTO_NUMBER_RANGE
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_RANGE) { ERROR_NUMBERS_COUNT }
        require(numbers.toSet().size == numbers.size) { ERROR_NUMBERS_DUPLICATE }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { ERROR_NUMBER_RANGE }
    }

    fun winningCount(inputNumbers: InputNumbers): Int {
        var winningCount = 0
        inputNumbers
            .winningNumbers
            .forEach { winningNumber ->
                winningCount += numbers.count { it == winningNumber }
            }

        return winningCount
    }

    fun isBonus(inputNumbers: InputNumbers): Boolean {
        if (winningCount(inputNumbers) == 5) {
            if (numbers.contains(inputNumbers.bonusNumber)) return true
        }

        return false
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
