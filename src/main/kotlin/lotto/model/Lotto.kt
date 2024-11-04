package lotto.model

import lotto.utils.Constants
import lotto.utils.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_SIZE) { ErrorMessage.INVALID_LOTTO_NUMBERS.getMessage() }
        require(numbers.toSet().size == numbers.size) { ErrorMessage.INVALID_DUPLICATE_NUMBER.getMessage() }
        require(numbers.all { it in Constants.RANDOM_MIN..Constants.RANDOM_MAX }) { ErrorMessage.INVALID_LOTTO_NUMBER.getMessage() }
    }

    fun get() = numbers

    fun match(winningNumbers: List<Int>): Int {
        val count = numbers.count { it in winningNumbers }
        return count
    }

    fun matchBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

}
