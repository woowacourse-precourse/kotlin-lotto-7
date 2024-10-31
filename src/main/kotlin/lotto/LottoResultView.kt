package lotto

class LottoResultView {
    fun outputWinningStatistics(lottoTicketsRank: List<LottoRank>) {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${lottoTicketsRank.count { it == LottoRank.FIFTH }}개")
        println("4개 일치 (50,000원) - ${lottoTicketsRank.count { it == LottoRank.FOURTH }}개")
        println("5개 일치 (1,500,000원) - ${lottoTicketsRank.count { it == LottoRank.THIRD }}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoTicketsRank.count { it == LottoRank.SECOND }}개")
        println("6개 일치 (2,000,000,000원) - ${lottoTicketsRank.count { it == LottoRank.FIRST }}개")
    }

    fun outputTotalProfitRate(lottoProfitRate: String) {
        println("총 수익률은 ${lottoProfitRate}입니다.")
    }
}