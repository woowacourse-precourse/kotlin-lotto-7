package lotto.util

object Constants {
    // 에러 메시지
    const val ERROR_PREFIX = "[ERROR]"
    const val ERROR_INVALID_PURCHASE_AMOUNT = "$ERROR_PREFIX 구입 금액은 1,000원 단위의 숫자여야 합니다."
    const val ERROR_INVALID_NUMBER_INPUT = "$ERROR_PREFIX 숫자만 입력 가능합니다."
    const val ERROR_INVALID_WINNING_NUMBERS_SIZE = "$ERROR_PREFIX 당첨 번호는 6개여야 합니다."
    const val ERROR_INVALID_LOTTO_NUMBERS_SIZE = "$ERROR_PREFIX 로또 번호는 6개여야 합니다."
    const val ERROR_NUMBER_OUT_OF_RANGE = "$ERROR_PREFIX 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_DUPLICATE_NUMBER = "$ERROR_PREFIX 번호는 중복될 수 없습니다."
    const val ERROR_BONUS_NUMBER_DUPLICATE = "$ERROR_PREFIX 보너스 번호는 당첨 번호와 중복될 수 없습니다."

    // 안내 메시지
    const val MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    const val MESSAGE_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
    const val MESSAGE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    const val MESSAGE_PURCHASED_LOTTOS = "%d개를 구매했습니다."
    const val MESSAGE_WINNING_STATISTICS = "당첨 통계\n---"
    const val MESSAGE_TOTAL_YIELD = "총 수익률은 %.1f%%입니다."

    // 로또 설정
    const val LOTTO_PRICE = 1_000
    const val LOTTO_NUMBER_COUNT = 6
    const val LOTTO_NUMBER_MIN = 1
    const val LOTTO_NUMBER_MAX = 45
}