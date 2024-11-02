package domain.enums

import util.ext.toThousandUnit

enum class Output(private val msg: String) {
    PURCHASE("%d개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    THREE_HYPHEN("---"),
    MATCH_COUNT("%d개 일치"),
    BONUS_MATCH_COUNT(", 보너스 볼 일치"),
    MATCHING_NUMBER("(%s원) - %d개"),
    TOTAL_RATE_OF_RETURN("총 수익률은 %s%%입니다.");

    override fun toString(): String = msg

    companion object {
        fun purchaseFormat(pay: String): Pair<String, Int> {
            val purchaseLottoCount = pay.toThousandUnit()
            return Pair(PURCHASE.toString().format(purchaseLottoCount), purchaseLottoCount)
        }

        fun matchCountFormat(count: Int): String {
            return MATCH_COUNT.toString().format(count)
        }

        fun matchingNumberFormat(reword: String, count: Int): String {
            return MATCHING_NUMBER.toString().format(reword, count)
        }

        fun totalRateOfReturnFormat(price: String): String {
            return TOTAL_RATE_OF_RETURN.toString().format(price)
        }
    }
}