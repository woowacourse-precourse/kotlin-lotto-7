package lotto.domain

class Bonus(
    private val inputNumber: String
) {
    private val _number: Int
    val number: Int
        get() = _number

    init {
        val rawNumber = parseInputNumber(inputNumber)
        validateNumberRange(rawNumber)
        _number = rawNumber
    }

    private fun parseInputNumber(inputNumber: String) =
        inputNumber.toIntOrNull() ?: throw IllegalArgumentException(INPUT_NUMBER_PARSE_ERROR_MESSAGE)

    private fun validateNumberRange(rawNumber: Int) =
        require(rawNumber in START_RANGE..END_RANGE) { NUMBER_RANGE_ERROR_MESSAGE }

    companion object {
        private const val START_RANGE = 1
        private const val END_RANGE = 45
        private const val INPUT_NUMBER_PARSE_ERROR_MESSAGE = "보너스 숫자는 숫자를 입력해야 합니다."
        private const val NUMBER_RANGE_ERROR_MESSAGE = "보너스 숫자는 $START_RANGE ~ $END_RANGE 중에서 입력해야 합니다."
    }
}
