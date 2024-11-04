package lotto.model

import lotto.global.Error.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { NOT_SIX_NUMBERS.message }
        require(numbers.toSet().size == 6) { HAS_DUPLICATE_NUMBERS.message }
    }

    fun contain(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun countMatching(target: Lotto): Int {
        return numbers.count { target.contain(it) }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}