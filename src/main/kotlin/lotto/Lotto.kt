package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "$ERROR $LOTTO_SIZE_MESSAGE" }
        require(numbers.distinct().size == numbers.size) { "$ERROR $LOTTO_NUMBER_DUPLICATE_MESSAGE" }
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val LOTTO_SIZE_MESSAGE = "로또 번호는 6개여야 합니다."
        const val LOTTO_NUMBER_DUPLICATE_MESSAGE = "로또 번호는 중복될 수 없습니다."
    }
}
