package lotto.domain.model

import java.text.NumberFormat
import java.util.Locale

enum class Prize(
    val matchingNumberCount: Int,
    val prizeAmountValue: Int,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    val prizeAmount: String
        get() = NumberFormat.getNumberInstance(Locale.KOREA).format(prizeAmountValue)

    companion object {
        fun getPrize(matchingNumberCount: Int, matchingBonusNumber: Boolean): Prize {
            return when {
                matchingNumberCount == FIRST_COUNT -> FIRST
                matchingNumberCount == SECOND_COUNT && matchingBonusNumber -> SECOND
                matchingNumberCount == THIRD_COUNT -> THIRD
                matchingNumberCount == FOURTH_COUNT -> FOURTH
                matchingNumberCount == FIFTH_COUNT -> FIFTH
                else -> NONE
            }
        }
        private const val FIRST_COUNT = 6
        private const val SECOND_COUNT = 5
        private const val THIRD_COUNT = 5
        private const val FOURTH_COUNT = 4
        private const val FIFTH_COUNT = 3
    }
}