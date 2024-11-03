package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { LottoErrorMessages.INVALID_SIZE }
        require(numbers.distinct().size == numbers.size) { LottoErrorMessages.DUPLICATE_NUMBERS }
        require(numbers.all { it in 1..45 }) { LottoErrorMessages.OUT_OF_RANGE }
        require(numbers == numbers.sorted()) { LottoErrorMessages.NOT_SORTED }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }

    object LottoErrorMessages {
        const val INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다."
        const val DUPLICATE_NUMBERS = "[ERROR] 로또 번호는 중복되지 않아야 합니다."
        const val OUT_OF_RANGE = "[ERROR] 모든 로또 번호는 1부터 45 사이여야 합니다."
        const val NOT_SORTED = "[ERROR] 로또 번호는 오름차순으로 정렬되어 있어야 합니다."
    }

}
