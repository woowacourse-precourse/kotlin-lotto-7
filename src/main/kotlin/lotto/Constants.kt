package lotto

object Constants {
    const val ERROR_INVALID_NUMBER_COUNT_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다."
    const val ERROR_INVALID_NUMBER_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_DUPLICATED_NUMBER_MESSAGE = "[ERROR] 로또 번호에는 중복된 숫자가 포함될 수 없습니다."
    const val ERROR_EMPTY_LOTTO_PURCHASE_MESSAGE = "[ERROR] 구입 금액을 입력해야 합니다."
    const val ERROR_NEGATIVE_LOTTO_PURCHASE_MESSAGE = "[ERROR] 구입 금액은 0보다 커야 합니다."
    const val ERROR_INVALID_LOTTO_PURCHASE_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다."
    const val ERROR_DIVIDE_LOTTO_PURCHASE_MESSAGE = "[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다."
    const val ERROR_DUPLICATED_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."

    const val INPUT_LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
    const val INPUT_WIN_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

    const val OUTPUT_LOTTO_TICKET_COUNT_MESSAGE = "%d개를 구매했습니다."
    const val OUTPUT_LOTTO_WINNING_MESSAGE = "당첨 통계"
}