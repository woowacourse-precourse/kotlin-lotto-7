package domain.enums

import util.ext.toThousandUnit

enum class Output(private val msg: String) {
    PURCHASE("%d개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    THREE_HYPHEN("---"),
    TOTAL_RATE_OF_RETURN("총 수익률은 %s%%입니다.");

    override fun toString(): String = msg

    companion object {
        fun getPurchase(pay: String): Pair<String, Int> {
            val purchaseLottoCount = pay.toThousandUnit()
            return Pair(PURCHASE.toString().format(purchaseLottoCount), purchaseLottoCount)
        }

        fun getTotalRateOfReturn(price: String): String {
            return TOTAL_RATE_OF_RETURN.toString().format(price)
        }
    }
}