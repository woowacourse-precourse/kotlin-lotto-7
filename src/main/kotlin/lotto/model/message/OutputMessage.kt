package lotto.model.message

enum class OutputMessage(val message: String) {
    LOTTO_TICKET_COUNT("\n%s개를 구매했습니다."),
    WINNING_STATISTICS_TITLE("\n당첨 통계\n---"),
    RANK_RESULT("%d개 일치%s (%s원) - %d개"),
    BONUS_TEXT(", 보너스 볼 일치"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.")
}