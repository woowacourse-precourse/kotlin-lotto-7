package lotto.view

object OutputView {
    private const val PURCHASE_COUNT_SCRIPT = "%d개를 구매했습니다."
    private const val WINNING_RESULT_SCRIPT = "당첨 통계\n---"
    private const val LOTTO_MATCH_FORMAT = "%d개 일치 (%d원) - %d개"
    private const val LOTTO_MATCH_FORMAT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%d원) - %d개"


    fun printLottoCount(lottoCount: Int) {
        println(PURCHASE_COUNT_SCRIPT.format(lottoCount))
    }

    fun printLottoNumber(numbers: Set<Int>) {
        println(numbers)
    }

    fun printWinningResult() {
        println(WINNING_RESULT_SCRIPT)
    }
}