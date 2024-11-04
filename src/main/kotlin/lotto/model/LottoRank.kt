package lotto.model

enum class LottoRank(val matchCount: Int, val prize: Int) {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    var count = 0
        private set

    fun increment() {
        count++
    }

    companion object {
        fun fromMatch(matchCount: Int, hasBonus: Boolean): LottoRank? {
            return when {
                matchCount == 6 -> SIX_MATCH
                matchCount == 5 && hasBonus -> FIVE_MATCH_WITH_BONUS
                matchCount == 5 -> FIVE_MATCH
                matchCount == 4 -> FOUR_MATCH
                matchCount == 3 -> THREE_MATCH
                else -> null
            }
        }
    }
}