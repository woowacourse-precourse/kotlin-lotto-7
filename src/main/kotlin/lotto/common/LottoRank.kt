package lotto.common

enum class LottoRank(val prize: Int, val matchCount: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NON(0, 0);

    companion object {
        fun getWinningRanks(): List<LottoRank> {
            return entries.filter { it != NON }.reversed()
        }
    }
}