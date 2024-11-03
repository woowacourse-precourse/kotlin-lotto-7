package lotto

enum class LottoRank(private val winNumbersCount: Int) {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    LOSE(2);

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