package lotto.model

import lotto.util.Error

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            println(Error.SIX_NUMBER)
            Error.SIX_NUMBER
        }
        require(numbers.toSet().size == 6) {
            println(Error.WINNING_DUPLICATION)
            Error.WINNING_DUPLICATION
        }
        require(numbers.all { it in 1..45 }) {
            println(Error.LOTTERY_RANGE)
            Error.LOTTERY_RANGE
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
