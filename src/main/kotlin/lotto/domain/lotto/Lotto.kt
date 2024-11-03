package lotto.domain.lotto

import lotto.validator.LottoValidator

class Lotto(private val numbers: List<Int>) {
    init {
        LottoValidator.validate(numbers)
    }

    fun isDuplicateNumber(number: Int): Boolean {
        return this.numbers.contains(number)
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]") { it.toString() }
    }
}
