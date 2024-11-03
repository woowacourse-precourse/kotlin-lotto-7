package lotto.model

import lotto.util.NumberValidation

class Lotto(private val numbers: List<Int>) {
    init {
        NumberValidation.validate(numbers)
         }

    fun countMatchingNumbers(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun containsBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
