package lotto

enum class Rank(
    val winningCount: Int,
    val money: Double,
    val bonusChance: Boolean = false,
) {
    FIFTH_RANK(3, 5_000.0),
    FOURTH_RANK(4, 50_000.0),
    THIRD_RANK(5, 1_500_000.0),
    SECOND_RANK(5, 30_000_000.0, true),
    FIRST_RANK(6, 2_000_000_000.0),
    ;

    companion object {
        fun matchRankInfo(count: Int, bonus: Boolean): Rank? {
            return entries.find {
                it.winningCount == count
                        && (it.bonusChance == bonus || !it.bonusChance)
            }
        }
    }
}