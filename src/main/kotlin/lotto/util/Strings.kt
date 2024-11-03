package lotto.util

object InputMessages {
    const val INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요."
    const val INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
}

object OutputMessages {
    const val TICKET_COUNT_MESSAGE = "개를 구매했습니다."
    const val RESULT_HEADER = "\n당첨 통계"
    const val DIVIDER = "---"
    const val FORMAT_RESULT = "%s (%s원) - %d개"
    const val FORMAT_MATCH_DESCRIPTION = "%d개 일치%s"
    const val BONUS_MATCH_MESSAGE = ", 보너스 볼 일치"
    const val PROFIT_RATE_MESSAGE = "총 수익률은 %s%%입니다."
}

object ErrorMessages {
    const val ERROR_INCORRECT_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다."
    const val ERROR_UNVALIDATED_NUMBER = "[ERROR] 숫자를 올바르게 입력해 주세요."
    const val ERROR_NOT_A_NUMBER = "[ERROR] 입력 값은 숫자여야 합니다."
    const val ERROR_NUMBER_SIZE = "[ERROR] 입력된 숫자는 6개여야 합니다."
    const val ERROR_NUMBER_RANGE = "[ERROR] 입력된 숫자는 1부터 45 사이여야 합니다."
    const val ERROR_NUMBER_DUPLICATE = "[ERROR] 입력된 숫자는 중복되지 않아야 합니다."
    const val ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."
}