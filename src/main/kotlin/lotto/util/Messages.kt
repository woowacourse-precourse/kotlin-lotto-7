package lotto.util

object ErrorMessages {
    // 로또 구입 금액 입력 에러 메시지
    const val INVALID_PURCHASE_AMOUNT_FORMAT = "[ERROR] 구입 금액은 유효한 정수 형태여야 합니다.\n"
    const val INVALID_PURCHASE_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.\n"

    // 로또 번호 에러 메시지
    const val INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다."
    const val DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복되지 않아야 합니다."

    // 당첨 번호 입력 에러 메시지
    const val INVALID_WINNING_NUMBERS_FORMAT = "[ERROR] 당첨 번호는 쉼표(,)로 구분된 정수 형태여야 합니다."
    const val INVALID_WINNING_NUMBERS_SIZE = "[ERROR] 당첨 번호는 6개여야 합니다."
    const val INVALID_WINNING_NUMBERS_RANGE = "[ERROR] 당첨 번호는 0보다 크고 46보다 작아야 합니다."
    const val DUPLICATE_WINNING_NUMBERS = "[ERROR] 당첨 번호는 중복될 수 없습니다."

    // 보너스 번호 입력 에러 메시지
    const val INVALID_BONUS_NUMBER_FORMAT = "[ERROR] 보너스 번호는 정수 형태여야 합니다."
    const val INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 0보다 크고 46보다 작아야 합니다."
    const val BONUS_NUMBER_ALREADY_IN_WINNING_NUMBERS = "[ERROR] 보너스 번호는 당첨 번호에 포함된 값일 수 없습니다."
}

object InputMessages {

    const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
    const val WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요."
    const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."

}

object InfoMessages {

    const val PURCHASE_AMOUNT_INFO = "개를 구매했습니다."
    const val WINNING_STATISTICS = "당첨 통계\n---"
    const val MATCH_COUNT_PRIZE_MESSAGE = "%d개 일치 (%s원) - %d개"
    const val MATCH_COUNT_BONUS_PRIZE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
    const val RETURN_RATE_INFO = "총 수익률은 %.1f%%입니다."

}