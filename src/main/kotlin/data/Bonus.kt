package data

import view.ErrorMessage

class Bonus(private val numbers: Int) {
    init {
        require(numbers in 1..45) { ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE }
    }

    val read: Int
        get() = numbers

    override fun toString(): String {
        return numbers.toString()
    }
}
