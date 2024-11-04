package lotto.model

import lotto.util.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    init {
        numbers
            .findDuplicates()
            .validateRange(LottoStore.LOTTO_MIN_NUMBER, LottoStore.LOTTO_MAX_NUMBER);
    }

    // TODO: 추가 기능 구현
    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]", separator = ", ") { it.toString() }
    }

    fun toList(): List<Int> {
        return numbers
    }

    fun isContain(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        fun fromInput(inputNumbers: String): Lotto {
            return fromList(inputNumbers.validateIntList())
        }

        fun fromList(numbers: List<Int>): Lotto {
            return Lotto(numbers
                .validateCount(LottoStore.LOTTO_NUMBER_COUNT)
                .findDuplicates()
                .validateRange(LottoStore.LOTTO_MIN_NUMBER, LottoStore.LOTTO_MAX_NUMBER)
            )
        }
    }
}
