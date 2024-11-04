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
        require(inputNumber.isNotEmpty()) { "당첨 번호는 비어있을 수 없습니다." }

    private fun splitInputNumber(inputNumber: String): List<String> {
        val rawWinningNumbers = inputNumber.split(",")
        return rawWinningNumbers
    }

    private fun parseRawWinningNumbers(rawWinningNumbers: List<String>) =
        rawWinningNumbers.map { number ->
            number.toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자를 입력해야 합니다.")
        }

    private fun validateWinningNumbers(numbers: List<Int>) {
        validateSize(numbers)
        validateUnique(numbers)
        validateNumberRange(numbers)
    }

    private fun validateSize(numbers: List<Int>) =
        require(numbers.size == 6) { "당첨 번호는 6개여야 합니다." }

    private fun validateUnique(numbers: List<Int>) =
        require(numbers.distinct().size == numbers.size) { "당첨 번호는 중복될 수 없습니다." }

    private fun validateNumberRange(numbers: List<Int>) =
        require(numbers.all { it in 1..45 }) { "당첨 번호는 1 ~ 45 중 하나여야 합니다." }
}
