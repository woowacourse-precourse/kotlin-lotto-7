package lotto.domain

import lotto.constants.ErrorConstants.ERROR_NUMBERS_COUNT
import lotto.constants.ErrorConstants.ERROR_NUMBERS_DUPLICATE
import lotto.constants.ErrorConstants.ERROR_NUMBER_RANGE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ERROR_NUMBERS_COUNT }
        require(numbers.toSet().size == 6) { ERROR_NUMBERS_DUPLICATE }
        require(numbers.all { it in 1..45 }) { ERROR_NUMBER_RANGE }
    }

    fun winningCount(inputNumbers: InputNumbers): Int {
        var winningCount = 0
        for (i in numbers.indices) {
            winningCount += numbers.count { it == inputNumbers.winningNumbers[i] }
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
