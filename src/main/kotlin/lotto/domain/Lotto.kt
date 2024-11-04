package lotto.domain

class Lotto(
    private val numbers: List<Int>
) {

    init {
        validateLotto(numbers)
    }

    fun getNumbers() = numbers.toList()

    override fun toString(): String = numbers.toString()

    private fun validateLotto(numbers: List<Int>) {
        requireNotEmpty(numbers)
        requireValidSize(numbers)
        requireUnique(numbers)
        requireVailNumberRange(numbers)
    }

    private fun requireNotEmpty(numbers: List<Int>) =
        require(numbers.isNotEmpty()) { NUMBER_EMPTY_ERROR_MESSAGE }

    private fun requireValidSize(numbers: List<Int>) =
        require(numbers.size == NUMBER_SIZE) { NUMBER_SIZE_ERROR_MESSAGE }

    private fun requireUnique(numbers: List<Int>) =
        require(numbers.distinct().size == numbers.size) { NUMBER_DISTINCT_ERROR_MESSAGE }

    private fun requireVailNumberRange(numbers: List<Int>) =
        require(numbers.all { it in START_RANGE..END_RANGE }) { NUMBER_RANGE_ERROR_MESSAGE }

    companion object {
        private const val START_RANGE = 1
        private const val END_RANGE = 45
        private const val NUMBER_SIZE = 6
        private const val NUMBER_EMPTY_ERROR_MESSAGE = "로또 번호는 비어있을 수 없습니다."
        private const val NUMBER_SIZE_ERROR_MESSAGE = "로또 번호는 6개여야 합니다."
        private const val NUMBER_DISTINCT_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다."
        private const val NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 $START_RANGE ~ $END_RANGE 중 하나여야 합니다."
    }
}
