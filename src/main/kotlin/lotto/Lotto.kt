package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ERROR_LOTTO_COUNT_MESSAGE }
    }

    fun getNumbers(): List<Int> = numbers.sorted()

    companion object {
        const val ERROR_LOTTO_COUNT_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다."
    }
}

