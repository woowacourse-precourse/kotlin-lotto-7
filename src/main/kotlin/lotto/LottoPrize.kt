package lotto

enum class LottoPrize(
    private val matchingCount: Int,
    private val price: Int,
    private val isMatchingBonusNumber: Boolean,
) {
    FIRST_PRIZE(6, 2_000_000_000, false),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000, false),
    FOURTH_PRIZE(4, 50_000, false),
    FIFTH_PRIZE(3, 5_000, false),
    NONE_PRIZE(0, 0, false);

    companion object {

        fun fromMatchingCount(matchingCount: Int, isMatchingBonusNumber: Boolean): LottoPrize {
            if (matchingCount in 0..2) {
                return NONE_PRIZE
            }

            if (matchingCount == 5) {
                return entries.find { it.matchingCount == matchingCount && it.isMatchingBonusNumber == isMatchingBonusNumber }
                    ?: throw IllegalArgumentException("예상치 못한 값입니다.")
            }

            return entries.find { it.matchingCount == matchingCount }
                ?: throw IllegalArgumentException("예상치 못한 값입니다.")
        }
    }
}