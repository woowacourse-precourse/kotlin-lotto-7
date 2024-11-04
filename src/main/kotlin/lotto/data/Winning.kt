package lotto.data

class Winning(private val input: String) {
    val numbers: List<Int>

    init {
        require(input.isNotEmpty()) { INPUT_EMPTY_ERROR_MESSAGE }
        require(input.split(DELIMITER).size == NUMBER_SIZE) { NUMBER_COUNT_IS_NOT_SIX_ERROR_MESSAGE }
        require(input.replace(DELIMITER, EMPTY_STRING).all { it.isDigit() }) { NUMBER_IS_NOT_ALL_DIGIT_ERROR_MESSAGE }
        require(!input.split(DELIMITER).any { it.startsWith(ZERO) }) { NUMBER_START_ZERO_ERROR_MESSAGE }
        require(input.split(DELIMITER).distinct().size == NUMBER_SIZE) { NUMBER_IS_DUPLICATION_ERROR_MESSAGE }
        require(input.split(DELIMITER).map { it.toIntOrNull() }
            .all { it != null }) { NUMBER_IS_OUT_OF_RANGE_ERROR_MESSAGE }
        numbers = input.split(DELIMITER).map { it.toInt() }
        require(numbers.all { it in WINNING_MIN_NUMBER..WINNING_MAX_NUMBER }) { NUMBER_IS_OUT_OF_RANGE_ERROR_MESSAGE }
    }

    companion object {
        private const val DELIMITER = ","
        private const val NUMBER_SIZE = 6
        private const val EMPTY_STRING = ""
        private const val ZERO = "0"
        private const val WINNING_MIN_NUMBER = 1
        private const val WINNING_MAX_NUMBER = 45
        private const val INPUT_EMPTY_ERROR_MESSAGE = "[ERROR] 당첨 번호가 입력되지 않았습니다. 6개의 번호를 쉼표(,)를 기준으로 입력해주세요."
        private const val NUMBER_COUNT_IS_NOT_SIX_ERROR_MESSAGE = "[ERROR] 6개의 당첨 번호를 입력해주세요."
        private const val NUMBER_IS_NOT_ALL_DIGIT_ERROR_MESSAGE = "[ERROR] 6개의 번호를 쉼표(,)를 기준으로 숫자만 입력해주세요."
        private const val NUMBER_START_ZERO_ERROR_MESSAGE = "[ERROR] 0으로 시작하지 않는 6개의 번호를 쉼표(,)를 기준으로 입력해주세요."
        private const val NUMBER_IS_DUPLICATION_ERROR_MESSAGE = "[ERROR] 중복되지 않는 6개의 번호를 입력해주세요."
        private const val NUMBER_IS_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 1 ~ 45 범위 내 6개의 번호를 입력해주세요."
    }
}