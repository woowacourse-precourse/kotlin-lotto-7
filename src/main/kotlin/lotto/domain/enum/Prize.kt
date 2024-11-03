package lotto.domain.enum

enum class Prize(
    val matchCount: Int,
    val money: Int,
    val bonusRequired: Boolean = false
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun getPrize(matchCount: Int, bonusMatch: Boolean): Prize {
            return entries.find { it.matchCount == matchCount && it.bonusRequired == bonusMatch } ?: NONE
        }
    }
}
