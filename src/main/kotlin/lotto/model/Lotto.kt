package lotto.model

import lotto.resources.LottoConfig.*
import lotto.resources.Messages.*

class Lotto(private val numbers: List<Int>) {
    init {
        // require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == LOTTO_LENGTH.value) { NOT_SIX_NUMBER.errorMessage() }
        require(numbers.distinct().size == LOTTO_LENGTH.value) {
            DUPLICATE_LOTTO_NUMBER.errorMessage()
        }
    }

    fun numbers(): List<Int> {
        return numbers
    }

    fun numbersText(): String {
        return "[${numbers.joinToString()}]"
    }
}
