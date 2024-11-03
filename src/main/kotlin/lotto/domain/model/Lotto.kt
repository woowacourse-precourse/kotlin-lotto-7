package lotto.domain.model

import lotto.util.validator.winningnumbers.WinningNumbersErrorType

data class Lotto(
    private val numbers: List<Int>
) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.size == numbers.toSet().size) { WinningNumbersErrorType.NO_DUPLICATE_LUCKY_NUMBERS}
    }

    val lottoNumbers: List<Int>
        get() = numbers
    // TODO: 추가 기능 구현

    override fun toString(): String {
        return numbers.joinToString(prefix = PREFIX, postfix = POSTFIX)
    }

    companion object {
        private const val PREFIX = "["
        private const val POSTFIX = "]"
    }
}
