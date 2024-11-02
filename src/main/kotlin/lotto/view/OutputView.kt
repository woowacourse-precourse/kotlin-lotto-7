package lotto.view

object OutputView {
    private const val PURCHASE_COUNT_SCRIPT = "%d개를 구매했습니다."

    fun printLottoCount(lottoCount: Int) {
        println(PURCHASE_COUNT_SCRIPT.format(lottoCount))
    }
}