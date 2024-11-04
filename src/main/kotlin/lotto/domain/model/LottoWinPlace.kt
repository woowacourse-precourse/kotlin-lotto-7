package lotto.domain.model

enum class LottoWinPlace(
    val prize: Int,
    val requiredMatchedNumberLength: Int,
    val shouldBonusWinningBeNumberMatched: Boolean,
) {
    FIRST_PLACE(
        prize = 2_000_000_000,
        requiredMatchedNumberLength = 6,
        shouldBonusWinningBeNumberMatched = false
    ),
    SECOND_PLACE(
        prize = 30_000_000,
        requiredMatchedNumberLength = 5,
        shouldBonusWinningBeNumberMatched = true
    ),
    THIRD_PLACE(
        prize = 1_500_000,
        requiredMatchedNumberLength = 5,
        shouldBonusWinningBeNumberMatched = false
    ),
    FOURTH_PLACE(
        prize = 50_000,
        requiredMatchedNumberLength = 4,
        shouldBonusWinningBeNumberMatched = false
    ),
    FIFTH_PLACE(
        prize = 5_000,
        requiredMatchedNumberLength = 3,
        shouldBonusWinningBeNumberMatched = false
    );

    companion object {
        fun findLottoWinPlace(
            matchedNumberLength: Int,
            isBonusWinningNumberMatched: Boolean,
        ): LottoWinPlace? {
            var candidates = entries.filter { it.requiredMatchedNumberLength == matchedNumberLength }

            if (candidates.hasMoreThanOneElement()) {
                candidates = candidates.filter { it.shouldBonusWinningBeNumberMatched == isBonusWinningNumberMatched }
            }

            return candidates.firstOrNull()
        }

        private fun List<LottoWinPlace>.hasMoreThanOneElement(): Boolean = size > 1
    }
}
