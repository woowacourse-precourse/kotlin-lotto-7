package lotto.model

enum class LottoRank(val matchCount: Int, val reward: Int, val bonusNumber: Boolean = false) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    companion object {
        fun getRank(matchCount: Int, reward: Int, bonusNumber: Boolean): LottoRank {
            return LottoRank.entries
                .find { it.matchCount == matchCount && it.reward == reward || it.bonusNumber == bonusNumber} ?: NONE
        }
    }
}