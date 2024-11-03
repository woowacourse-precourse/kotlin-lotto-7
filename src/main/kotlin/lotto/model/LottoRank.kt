package lotto.model

enum class LottoRank(val matchCount: Int, val reward: Int, val bonusNumber: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun getRank(matchCount: Int, bonusNumber: Boolean): LottoRank {
            return LottoRank.entries
                .find { it.matchCount == matchCount || (it.matchCount == matchCount && it.bonusNumber == bonusNumber) } ?: NONE
        }
    }
}