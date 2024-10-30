package lotto.model

import lotto.resources.Messages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == 6) {
            Messages.DUPLICATE_LOTTO_NUMBER.errorMessage()
        }
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }
    fun getLottoNumbersText(): String {
        return "[${numbers.joinToString()}]"
    }
}
