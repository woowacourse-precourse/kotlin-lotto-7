package lotto.model

import lotto.util.Constant
import lotto.util.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constant.LOTTO_NUMBERS_COUNT) { ErrorMessage.LOTTO_NUMBERS_COUNT_MISMATCH }
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
