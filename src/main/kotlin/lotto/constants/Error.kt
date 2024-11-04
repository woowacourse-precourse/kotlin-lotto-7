package lotto.constants

object Error {

    const val ERROR_BONUS_NUMBER_NOT_INTEGER = "[ERROR] 보너스번호는 정수여야 합니다."
    const val ERROR_BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."

    const val ERROR_WINNING_NUMBER_NOT_INTEGER = "[ERROR] 당첨 번호는 정수여야 합니다."
    const val ERROR_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다."
    const val ERROR_WINNING_NUMBER_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_WINNING_NUMBER_DUPLICATE = "[ERROR] 당첨 번호는 중복될 수 없습니다."

    const val ERROR_AMOUNT_NOT_INTEGER = "[ERROR] 구입금액은 정수여야 합니다."
    const val ERROR_AMOUNT_NEGATIVE_OR_ZERO = "[ERROR] 구입금액은 양수여야 합니다."
    const val ERROR_AMOUNT_NOT_MULTIPLE_OF_TICKET_PRICE = "[ERROR] 구입금액은 %d원 단위여야 합니다."

}