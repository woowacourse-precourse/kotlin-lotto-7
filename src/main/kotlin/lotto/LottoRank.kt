package lotto

enum class LottoRank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    companion object {
        fun getRank(matchCount: Int, matchBonus: Boolean): LottoRank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (matchBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }
    }
}

