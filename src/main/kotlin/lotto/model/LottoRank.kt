package lotto.model

enum class LottoRank(val matchCount: Int, val hasBonus: Boolean, val prize: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_00_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    FAIL(0, false, 0);

    companion object {
        fun getRank(matchCount: Int, hasBonus: Boolean): LottoRank {
            return entries.find { it.matchCount == matchCount && it.hasBonus == hasBonus } ?: FAIL
        }
    }
}
