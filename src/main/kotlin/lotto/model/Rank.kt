package lotto.model

enum class Rank(val matchCount: Int, val winningAmount: Int) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        fun of(matchCount: Int, bonusMatched: Boolean): Rank {
            return enumValues<Rank>()
                .firstOrNull { it.matchCount == matchCount && (it != SECOND || bonusMatched) } ?: MISS
        }
    }
}
