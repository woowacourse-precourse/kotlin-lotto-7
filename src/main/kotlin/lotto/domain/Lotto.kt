package lotto.domain

import lotto.constants.ErrorConstant

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.distinct().size) { ErrorConstant.ERROR_WINNING_NUMBER_DUPLICATED }
        require(numbers.all { it in 1..45 }) { ErrorConstant.ERROR_WINNING_NUMBER_OUT_OF_RANGE }
    }

    fun getNumber(): List<Int> {
        return numbers
    }
}