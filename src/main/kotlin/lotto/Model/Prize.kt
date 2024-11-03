package lotto.Model

enum class Prize(val matchCount: Int, val bonus: Boolean, val prizeMoney: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    companion object {
        fun getPrize(matchCount: Int, matchBonus: Boolean): Prize? =
            values().firstOrNull { it.matchCount == matchCount && it.bonus == matchBonus }

        fun getPrizesToPrint(): List<Prize> =
            values().filter { it.matchCount >= 3 }.sortedBy { it.matchCount }
    }
}