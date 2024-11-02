package lotto

data class LottoResultDetail(
    val lottoRankList: List<LottoRank>,
    val rateOfReturn: Double
) {
    val roundedRateOfReturn: String
        get() = String.format("%.1f", rateOfReturn)
}
