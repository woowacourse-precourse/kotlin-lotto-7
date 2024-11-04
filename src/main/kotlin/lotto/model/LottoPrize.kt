package lotto.model

enum class LottoPrize(
    val matchingCount: Int,
    val price: Int,
    val isMatchingBonusNumber: Boolean,
) {
    FIRST_PRIZE(6, 2_000_000_000, false),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000, false),
    FOURTH_PRIZE(4, 50_000, false),
    FIFTH_PRIZE(3, 5_000, false),
    NONE_PRIZE(0, 0, false);

    companion object {
        private val NONE_MATCHING_COUNT_RANGE = 0..2

        fun fromMatchingCount(matchingCount: Int, isMatchingBonusNumber: Boolean): LottoPrize {
            if (matchingCount in NONE_MATCHING_COUNT_RANGE) {
                return NONE_PRIZE
            }

            if (matchingCount == SECOND_PRIZE.matchingCount) {
                return entries.find { it.isMatchingBonusNumber == isMatchingBonusNumber }
                    ?: throw IllegalArgumentException("[ERROR] 로또 번호 맞은 개수가 예상 범위 밖입니다.")
            }

            return entries.find { it.matchingCount == matchingCount }
                ?: throw IllegalArgumentException("[ERROR] 로또 번호 맞은 개수가 예상 범위 밖입니다.")
        }
    }
}