package lotto.data

class Bonus(
    private val input: String,
    private val winning: Winning
) {
    val number: Int

    init {
        require(input.isNotEmpty()) { INPUT_EMPTY_ERROR_MESSAGE }
        require(input.all { it.isDigit() }) { NUMBER_IS_NOT_ALL_DIGIT_ERROR_MESSAGE }
        require(!input.startsWith(ZERO)) { NUMBER_START_ZERO_ERROR_MESSAGE }
        require(input.toIntOrNull() != null) { NUMBER_IS_OUT_OF_RANGE_ERROR_MESSAGE }
        number = input.toInt()
        require(number in BONUS_MIN_NUMBER..BONUS_MAX_NUMBER) { NUMBER_IS_OUT_OF_RANGE_ERROR_MESSAGE }
        require(!winning.numbers.contains(number)) { BONUS_NUMBER_IN_WINNING_NUMBER_ERROR_MESSAGE }
    }

    companion object {
        private const val ZERO = "0"
        private const val BONUS_MIN_NUMBER = 1
        private const val BONUS_MAX_NUMBER = 45
        private const val INPUT_EMPTY_ERROR_MESSAGE = "[ERROR] 보너스 번호가 입력되지 않았습니다. 보너스 번호를 입력해주세요."
        private const val NUMBER_IS_NOT_ALL_DIGIT_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요."
        private const val NUMBER_START_ZERO_ERROR_MESSAGE = "[ERROR] 0으로 시작하지 않는 번호를 입력해주세요."
        private const val NUMBER_IS_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 1 ~ 45 범위 내 1개의 번호를 입력해주세요."
        private const val BONUS_NUMBER_IN_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복되지 않는 번호로 입력해주세요."
    }
}