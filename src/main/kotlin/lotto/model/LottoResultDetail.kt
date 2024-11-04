package lotto.model

data class LottoResultDetail(
    val winningRankList: List<LottoRank>,
    val rateOfReturn: Double
) {
    val roundedRateOfReturnText: String
        get() = String.format("%.1f", rateOfReturn)
}
