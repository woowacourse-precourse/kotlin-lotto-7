package lotto

enum class LottoRank(val prizeMoney: Int) {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    LOSE(0);

    companion object {
        fun getRank(winNumbersCount: Int, isWinBonusNumber: Boolean): LottoRank {
            return when (winNumbersCount) {
                6 -> FIRST
                5 -> if (isWinBonusNumber) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> LOSE
            }
        }
    }
}