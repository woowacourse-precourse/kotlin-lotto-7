package lotto.model

enum class LottoRank(val matchCount: Int, val reward: String, val bonusNumber: Boolean = false) {
    FIFTH(3, "5,000"),
    FOURTH(4, "50,000"),
    THIRD(5, "1,500,000"),
    SECOND(5, "30,000,000", true),
    FIRST(6, "2,000,000,000"),
    NONE(0, "0");

    companion object {
        fun getRank(matchCount: Int, bonusNumber: Boolean): LottoRank {
            return LottoRank.entries
            .find { it.matchCount == matchCount && (!it.bonusNumber || it.bonusNumber == bonusNumber) } ?: NONE
        }
    }
}