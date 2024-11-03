package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { ERROR_INVALID_NUMBER_COUNT }
        require(numbers.distinct().size == 6) { ERROR_DUPLICATE_NUMBER }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    companion object {
        const val ERROR_INVALID_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다."
        const val ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다."
    }
}