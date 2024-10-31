package lotto

object Constants {
    const val INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해주세요."
    const val INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해주세요."
    const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요."
    const val LOTTO_PRICE = 1000

    const val ERROR_AMOUNT_NOT_NUMBER = "[ERROR] 구입 금액은 정수여야 합니다."
    const val ERROR_AMOUNT_NOT_POSITIVE = "[ERROR] 구입 금액은 0보다 커야 합니다."
    const val ERROR_AMOUNT_NOT_DIVIDE_BY_1000 = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다."

    const val ERROR_WINNING_NUMBERS_NOT_NUMBER = "[ERROR] 당첨 번호는 정수여야 합니다."
    const val ERROR_WINNING_NUMBERS_INCORRECT_SIZE = "[ERROR] 당첨 번호는 6개여야 합니다."
    const val ERROR_WINNING_NUMBERS_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_WINNING_NUMBERS_DUPLICATE = "[ERROR] 당첨 번호는 중복되지 않아야 합니다."

    const val ERROR_BONUS_NUMBER_NOT_NUMBER = "[ERROR] 보너스 번호는 정수여야 합니다."
    const val ERROR_BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."
}