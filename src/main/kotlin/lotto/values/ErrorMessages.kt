package lotto.values

object ErrorMessages {
    const val PAYMENT_IS_EMPTY = "[ERROR] 구입 금액을 입력해야 합니다."
    const val PAYMENT_NOT_A_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다."
    const val PAYMENT_NEGATIVE_NUMBER = "[ERROR] 구입 금액은 양수여야 합니다."
    const val PAYMENT_NOT_DIVISIBLE_BY_1000 = "[ERROR] 구입 금액은 1,000원 단위여야 합니다."

    const val WINNING_NUMBERS_EMPTY = "[ERROR] 당첨 번호를 입력해야 합니다."
    const val WINNING_NUMBER_NOT_A_NUMBER = "[ERROR] 당첨 번호는 숫자여야 합니다."
    const val WINNING_NUMBERS_COUNT_IS_NOT_SIX = "[ERROR] 당첨 번호는 6개를 입력해야 합니다."
    const val WINNING_NUMBER_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
    const val DUPLICATE_WINNING_NUMBERS = "[ERROR] 당첨 번호는 중복되지 않은 수로 이루어져야 합니다."

    const val BONUS_NUMBER_EMPTY = "[ERROR] 보너스 번호를 입력해야 합니다."
    const val BONUS_NUMBER_NOT_A_NUMBER = "[ERROR] 보너스 번호는 숫자여야 합니다."
    const val BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    const val DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."
}