package utils

object ErrorMessages {
    private const val ERROR = "[ERROR] "

    const val MONEY_NUMBER_ERROR = ERROR + "금액은 숫자로 입력해야 합니다."
    const val MONEY_POSITIVE_ERROR = ERROR + "금액은 양수로 입력해야 합니다."
    const val MONEY_1000_UNIT_ERROR = ERROR + "금액은 1,000원 단위로 입력해야 합니다."
    const val MONEY_MAX_VALUE_ERROR = ERROR + "금액은 2,147,483,647원 이하로 입력해야 합니다."

    const val WINNING_NUMBERS_COUNT_ERROR = ERROR + "당첨 번호는 6개여야 합니다."
    const val WINNING_NUMBERS_NUMBER_ERROR = ERROR + "당첨 번호는 숫자로 입력해야 합니다."
    const val WINNING_NUMBERS_RANGE_ERROR = ERROR + "당첨 번호는 1~45 사이의 숫자여야 합니다."
    const val WINNING_NUMBERS_DUPLICATE_ERROR = ERROR + "당첨 번호는 중복되어서는 안됩니다."

    const val BONUS_NUMBER_NUMBER_ERROR = ERROR + "보너스 번호는 숫자로 입력해야 합니다."
    const val BONUS_NUMBER_RANGE_ERROR = ERROR + "보너스 번호는 1~45 사이의 숫자여야 합니다."
    const val BONUS_NUMBER_DUPLICATE_ERROR = ERROR + "보너스 번호는 당첨 번호와 중복될 수 없습니다."

}