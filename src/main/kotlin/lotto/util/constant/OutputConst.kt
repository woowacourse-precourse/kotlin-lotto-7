package lotto.util.constant

object OutputConst {
    private const val LOTTO_QUANTITY = "\n%s개를 구매했습니다."
    fun getLottoQuantityMessage(lottoQuantity: Int): String = LOTTO_QUANTITY.format(lottoQuantity)

    const val RESULT = "\n당첨 통계\n---"
    const val THREE_MATCHED = "3개 일치 (5,000원)"
    const val FOUR_MATCHED = "4개 일치 (50,000원)"
    const val FIVE_MATCHED = "5개 일치 (1,500,000원)"
    const val FIVE_MATCHED_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원)"
    const val SIX_MATCHED = "6개 일치 (2,000,000,000원)"

    private const val LOTTO_COUNT = "- %s개"
    fun matchedLotteries(count: Int): String = LOTTO_COUNT.format(count)

    private const val TOTAL_YIELD = "총 수익률은 %s%%입니다."
    fun getTotalYieldMessage(yield: String): String = TOTAL_YIELD.format(yield)
}