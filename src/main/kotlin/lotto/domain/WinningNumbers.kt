package lotto.domain

class WinningNumbers(
    private val inputNumber: String
) {
    private val _winningNumbers: List<Int>
    val winningNumbers: List<Int>
        get() = _winningNumbers

    init {
        validateInputNumberNotEmpty(inputNumber)
        val rawWinningNumbers = splitInputNumber(inputNumber)
        val winningNumbers = parseRawWinningNumbers(rawWinningNumbers)
        validateWinningNumbers(winningNumbers)
        _winningNumbers = winningNumbers
    }

    private fun validateInputNumberNotEmpty(inputNumber: String) =
        require(inputNumber.isNotEmpty()) { NUMBER_EMPTY_ERROR_MESSAGE }

    private fun splitInputNumber(inputNumber: String): List<String> {
        val rawWinningNumbers = inputNumber.split(",")
        return rawWinningNumbers
    }

    private fun parseRawWinningNumbers(rawWinningNumbers: List<String>) =
        rawWinningNumbers.map { number ->
            number.toIntOrNull() ?: throw IllegalArgumentException(NUMBER_ERROR_MESSAGE)
        }

    private fun validateWinningNumbers(numbers: List<Int>) {
        validateSize(numbers)
        validateUnique(numbers)
        validateNumberRange(numbers)
    }

    private fun validateSize(numbers: List<Int>) =
        require(numbers.size == NUMBER_SIZE) { NUMBER_SIZE_ERROR_MESSAGE }

    private fun validateUnique(numbers: List<Int>) =
        require(numbers.distinct().size == numbers.size) { NUMBER_DISTINCT_ERROR_MESSAGE }

    private fun validateNumberRange(numbers: List<Int>) =
        require(numbers.all { it in START_RANGE..END_RANGE }) { NUMBER_RANGE_ERROR_MESSAGE }

    companion object {
        private const val START_RANGE = 1
        private const val END_RANGE = 45
        private const val NUMBER_SIZE = 6
        private const val NUMBER_EMPTY_ERROR_MESSAGE = "당첨 번호는 비어있을 수 없습니다."
        private const val NUMBER_ERROR_MESSAGE = "당첨 번호는 숫자를 입력해야 합니다."
        private const val NUMBER_SIZE_ERROR_MESSAGE = "당첨 번호는 6개여야 합니다."
        private const val NUMBER_DISTINCT_ERROR_MESSAGE = "당첨 번호는 중복될 수 없습니다."
        private const val NUMBER_RANGE_ERROR_MESSAGE = "당첨 번호는 $START_RANGE ~ $END_RANGE 중 하나여야 합니다."
    }
}
