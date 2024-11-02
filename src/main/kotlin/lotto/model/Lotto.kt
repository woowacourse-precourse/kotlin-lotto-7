package lotto.model

import lotto.utils.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ErrorMessage.INVALID_LOTTO_NUMBERS.getMessage() }
        require(numbers.toSet().size == 6) { ErrorMessage.INVALID_DUPLICATE_NUMBER.getMessage() }
        require(numbers.all { it in 1..45 }) { ErrorMessage.INVALID_LOTTO_NUMBER.getMessage() }
    }

    fun get() = numbers

    fun match(winningNumbers: List<Int>, bonusNumber: Int): Int {
        val count = numbers.count { it in winningNumbers }
        val bonusCount = numbers.count { it == bonusNumber }
        return when (count) {
            6 -> 1
            5 -> if (bonusCount == 1) 2 else 3
            4 -> 4
            3 -> 5
            else -> 0
        }
    }

}
