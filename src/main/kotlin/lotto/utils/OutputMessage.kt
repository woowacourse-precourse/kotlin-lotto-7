package lotto.utils

enum class OutputMessage(private val message: String) {
    PURCHASED_LOTTOS("%d개를 구매했습니다."),
    MATCH_COUNT("%d개 일치 (%,d원) - %d개"),
    MATCH_COUNT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    RESULT_TITLE("당첨 통계"),
    DIVIDER("---------");

    fun format(vararg args: Any?): String {
        return String.format(message, *args)
    }
}