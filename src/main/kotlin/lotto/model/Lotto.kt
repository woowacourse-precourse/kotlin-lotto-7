package lotto.model

import lotto.utils.LottoException

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { LottoException.SHORTAGE }
        require(numbers.size == numbers.toSet().size) { LottoException.DUPLICATION }
        numbers.forEach {
            require(it > 0 && it < 46) { LottoException.NOT_LOTTO }
        }
    }

    fun returnNumbers(): List<Int> {
        return numbers
    }
}