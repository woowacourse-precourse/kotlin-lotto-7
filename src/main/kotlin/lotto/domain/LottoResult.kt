package lotto.domain

import lotto.util.prettyNumberString

enum class LottoResult(val prize: Long, private val condition: String) {
    LOSE(0, "낙첨"),
    FIFTH(5_000, "3개 일치"),
    FOURTH(50_000, "4개 일치"),
    THIRD(1_500_000, "5개 일치"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(2_000_000_000, "6개 일치");

    override fun toString(): String {
        return "$condition (${prize.prettyNumberString}원)"
    }

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