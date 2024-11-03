package lotto

class OutputView {

    fun printLottoNumbers(lottos: List<Lotto>) {
        println("${lottos.size}${LOTTOS_PURCHASED_MESSAGE}")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printResult(matchResults: Map<LottoMatchType, Int>, profitRate: Double) {
        println(WINNING_STATISTICS_MESSAGE)
        println(DIVIDER)
        LottoMatchType.values().forEach { matchType ->
            println("$matchType - ${matchResults.getOrDefault(matchType, 0)}개")
        }
        println(TOTAL_PROFIT_MESSAGE.format(profitRate))
    }

    companion object {
        const val LOTTOS_PURCHASED_MESSAGE = "개를 구매했습니다."
        const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
        const val DIVIDER = "---"
        const val TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다."
    }
}