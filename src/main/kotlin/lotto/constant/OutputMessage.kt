package lotto.constant

enum class OutputMessage(val message: String) {
    PURCHASE_LOTTO_COUNT("%d개를 구매했습니다."),
    RESULT_TITLE("당첨 통계\n---"),
    FIFTH("3개 일치 (5,000원) - %d개"),
    FOURTH("4개 일치 (50,000원) - %d개"),
    THIRD("5개 일치 (1,500,000원) - %d개"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST("6개 일치 (2,000,000,000원) - %d개"),
    PRICE_RATIO("총 수익률은 %.1f%%입니다.");

    fun display(count: Int) {
        println(message.format(count))
    }

    fun display() {
        println(message)
    }

    fun display(ratio: Double) {
        println(message.format(ratio))
    }
}