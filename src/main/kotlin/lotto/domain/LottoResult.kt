package lotto.domain

enum class LottoResult(val prize: Long) {
    FIRST(2_000_000_000), SECOND(30_000_000), THIRD(1_500_000), FOURTH(50_000), FIFTH(5_000), LOSE(0);

    companion object {
        fun of(matchedNumbersCount: Int, bonusMatched: Boolean): LottoResult {
            if (matchedNumbersCount == 5 && bonusMatched) return SECOND

            return when (matchedNumbersCount) {
                3 -> FIFTH
                4 -> FOURTH
                5 -> THIRD
                6 -> FIRST
                else -> LOSE
            }
        }
    }
}