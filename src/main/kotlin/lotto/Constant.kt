package lotto

object Constant {
    const val INPUT_BUY_MESSAGE = "구입금액을 입력해 주세요."
    const val LOTTO_PRICE = 1000
    const val BOUGHT_LOTTO_MESSAGE = "개를 구매했습니다."
    const val INPUT_WINNER_NUMBER = "당첨 번호를 입력해 주세요."
    const val INPUT_SPECIAL_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
    const val RESULT_MESSAGE = "당첨 통계\n---"
    const val RESULT_THREE_MATCH = "3개 일치 (5,000원) - %d개"
    const val RESULT_FOUR_MATCH = "4개 일치 (50,000원) - %d개"
    const val RESULT_FIVE_MATCH = "5개 일치 (1,500,000원) - %d개"
    const val RESULT_FIVE_SPECIAL_MATCH = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
    const val RESULT_SIX_MATCH = "6개 일치 (2,000,000,000원) - %d개"

    const val ERROR_SPECIAL_NUMBER_INVALID_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호에 속하지 않은 1부터 45 사이의 정수여야 합니다."
    const val ERROR_BUY_AMOUNT_INVALID_MESSAGE = "[ERROR] 구매금액은 1000의 배수인 정수여야 합니다."
    const val ERROR_WINNER_NUMBER_INVALID_MESSAGE = "[ERROR] 당첨 번호는 서로 다른 6개의 1부터 45사이의 정수여야 합니다."
}