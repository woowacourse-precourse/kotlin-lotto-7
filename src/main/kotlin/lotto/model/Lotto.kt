package lotto.model

import lotto.global.Error.*
import lotto.global.LOTTO_NUMBERS_SIZE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBERS_SIZE) { NOT_SIX_NUMBERS.message }
        require(numbers.toSet().size == LOTTO_NUMBERS_SIZE) { HAS_DUPLICATE_NUMBERS.message }
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