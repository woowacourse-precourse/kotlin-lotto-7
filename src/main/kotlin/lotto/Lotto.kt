package lotto

import lotto.LottoConstants.LOTTO_NUMBER_RANGE
import lotto.LottoConstants.LOTTO_NUMBER_SIZE
import validator.LottoGenerator.Companion.GENERATOR_ERROR_FORMAT
import validator.RangeValidator.Companion.LOTTO_COUNT_ERROR
import validator.RangeValidator.Companion.RANGE_ERROR_FORMAT

class Lotto(private val numbers: List<Int>) {
    init {
        require(isSixLength(numbers)) { LOTTO_COUNT_ERROR }
        require(isNotDuplicated(numbers)) { GENERATOR_ERROR_FORMAT }
        require(isInRange(numbers)) { RANGE_ERROR_FORMAT }
    }

    private fun isSixLength(numbers: List<Int>): Boolean {
        return numbers.size == LOTTO_NUMBER_SIZE
    }

    private fun isNotDuplicated(numbers: List<Int>): Boolean {
        return numbers.distinct().size == numbers.size
    }

    private fun isInRange(numbers: List<Int>): Boolean {
        return numbers.all { it in LOTTO_NUMBER_RANGE }
    }

    fun isSameList(inputLottoNum: List<Int>, randomLottoNum: List<Int>): Boolean {
        return inputLottoNum.sorted() == randomLottoNum.sorted()
    }

    fun countMatch(otherLotto: Lotto): Int {
        return numbers.fold(0) { total, number ->
            total + if (otherLotto.numbers.contains(number)) 1 else 0
        }
    }

    fun contains(number: Int) = numbers.contains(number)

}
