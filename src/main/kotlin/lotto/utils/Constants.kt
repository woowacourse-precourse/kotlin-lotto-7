package lotto.utils

object Constants {
    const val INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해주세요."
    const val INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해주세요."
    const val INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해주세요."

    const val OUTPUT_RESULT_MESSAGE = "\n당첨 통계"
    const val LINE_SEPARATOR = "---"

    private const val MATCH_AMOUNT = "%d개"
    const val FIRST_MATCH_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - $MATCH_AMOUNT"
    const val SECOND_MATCH_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - $MATCH_AMOUNT"
    const val THIRD_MATCH_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - $MATCH_AMOUNT"
    const val FOURTH_MATCH_PRIZE_MESSAGE = "4개 일치 (50,000원) - $MATCH_AMOUNT"
    const val FIFTH_MATCH_PRIZE_MESSAGE = "3개 일치 (5,000원) - $MATCH_AMOUNT"

    const val NUMBER_DELIMITER = ","
    const val LOTTO_PRICE = 1000
    const val LOTTO_NUMBERS_SIZE = 6
    const val LOTTO_NUMBER_MIN = 1
    const val LOTTO_NUMBER_MAX = 45

    const val ZERO = 0
    const val THREE = 3
    const val FOUR = 4
    const val FIVE = 5
    const val SIX = 6

    const val FIRST_PRIZE = 2_000_000_000
    const val SECOND_PRIZE = 30_000_000
    const val THIRD_PRIZE = 1_500_000
    const val FOURTH_PRIZE = 50_000
    const val FIFTH_PRIZE = 5_000
    const val NO_PRIZE = 0

    const val ERROR_AMOUNT_NOT_NUMBER = "[ERROR] 구입 금액은 정수여야 합니다."
    const val ERROR_AMOUNT_UNDER_1000 = "[ERROR] 구입 금액은 1000원 이상이어야 합니다."
    const val ERROR_AMOUNT_NOT_DIVIDE_BY_1000 = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다."

    const val ERROR_LOTTO_NUMBERS_INCORRECT_SIZE = "[ERROR] 로또 번호는 6개여야 합니다."
    const val ERROR_LOTTO_NUMBERS_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_LOTTO_NUMBERS_DUPLICATE = "[ERROR] 로또 번호는 중복되지 않아야 합니다."

    const val ERROR_WINNING_NUMBERS_NOT_NUMBER = "[ERROR] 당첨 번호는 정수여야 합니다."
    const val ERROR_WINNING_NUMBERS_INCORRECT_SIZE = "[ERROR] 당첨 번호는 6개여야 합니다."
    const val ERROR_WINNING_NUMBERS_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_WINNING_NUMBERS_DUPLICATE = "[ERROR] 당첨 번호는 중복되지 않아야 합니다."

    const val ERROR_BONUS_NUMBER_NOT_NUMBER = "[ERROR] 보너스 번호는 정수여야 합니다."
    const val ERROR_BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."
}