package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { ERROR_INVALID_NUMBER_COUNT }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    companion object {
        const val ERROR_INVALID_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다."
    }
}
