package lotto.model

enum class LottoRank(val matchCount: Int, val bonusMatch: Boolean = false, val prize: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    companion object {
        fun getRank(matchCount: Int, bonusMatch: Boolean): LottoRank? {
            return entries.find {
                it.matchCount == matchCount && it.bonusMatch == bonusMatch
            } ?: entries.find {
                it.matchCount == matchCount && !it.bonusMatch
            }
        }
    }
}