package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "$ERROR $LOTTO_SIZE_MESSAGE" }
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val LOTTO_SIZE_MESSAGE = "로또 번호는 6개여야 합니다."
    }
}
