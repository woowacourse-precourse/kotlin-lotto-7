package lotto.util

enum class OutputMessages(val message: String) {
    MESSAGE_INPUT_PAYMENT("구입금액을 입력해 주세요."),
    PRINT_AMOUNT_TICKETS("개를 구매했습니다."),
    MESSAGE_PRIZE_NUMBER("당첨 번호를 입력해 주세요."),
    MESSAGE_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    MESSAGE_RESULT("당첨 통계\n---\n"),
    PRINT_RESULT_THREE("3개 일치 (5,000원) - "),
    PRINT_RESULT_FOUR("4개 일치 (50,000원) - "),
    PRINT_RESULT_FIVE("5개 일치 (1,500,000원) - "),
    PRINT_RESULT_FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRINT_RESULT_ALL("6개 일치 (2,000,000,000원) - "),
    RESULT("총 수익률은 "),
    UNIT_CORRECT("개\n"),
    RESULT_SECOND("%입니다."),
    RATE_FORMAT("#,###.#"),
    NUMBER_FORMAT("#,###"),
    NEW_LINE("\n")
}