package lotto.util

object Constants {
    // 에러 메세지
    const val PURCHASE_AMOUNT_ERROR = "[ERROR] 구입 금액은 1,000원 단위여야 합니다."
    const val PURCHASE_AMOUNT_NUMBER_ERROR = "[ERROR] 구입 금액은 숫자여야 합니다."
    const val WINNING_NUMBERS_SIZE_ERROR = "[ERROR] 당첨 번호는 6개여야 합니다."
    const val WINNING_NUMBERS_RANGE_ERROR = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
    const val WINNING_NUMBERS_DUPLICATE_ERROR = "[ERROR] 당첨 번호는 중복될 수 없습니다."
    const val BONUS_NUMBER_RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    const val BONUS_NUMBER_DUPLICATE_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."
    const val BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 숫자여야 합니다."
    const val WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호는 숫자여야 합니다."

    // 메세지
    const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
    const val WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요."
    const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
    const val PURCHASED_LOTTOS_MESSAGE = "%d개를 구매했습니다."
    const val LOTTO_NUMBERS_SEPARATOR = ", "
    const val RESULT_STATISTICS = "당첨 통계"
    const val RESULT_SEPARATOR = "---"
    const val YIELD_MESSAGE = "총 수익률은 %.1f%%입니다."

    // 기본 조건
    const val LOTTO_PRICE = 1_000
    const val LOTTO_NUMBER_COUNT = 6
    const val LOTTO_NUMBER_RANGE_START = 1
    const val LOTTO_NUMBER_RANGE_END = 45
}
