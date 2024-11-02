package lotto.domain

enum class Rank(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun valueOf(matchCount: Int, matchBonus: Boolean): Rank {
            if (matchCount == SECOND.matchCount && matchBonus) return SECOND
            if (matchCount == SECOND.matchCount && !matchBonus) return THIRD
            return entries.find { it.matchCount == matchCount } ?: NONE
        }
    }
}