package lotto.model

import lotto.util.Constant
import lotto.util.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constant.LOTTO_NUMBERS_COUNT) { ErrorMessage.LOTTO_NUMBERS_COUNT_MISMATCH }
        require(numbers.size == numbers.toSet().size) { ErrorMessage.LOTTO_NUMBERS_NOT_DISTINCT }
        require(numbers.all { it in Constant.LOTTO_NUMBERS_MIN..Constant.LOTTO_NUMBERS_MAX }) { ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE }
    }

    fun countMatches(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }

    fun hasBonus(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }

    override fun equals(other: Any?): Boolean {
        return other is Lotto && this.numbers == other.numbers
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
