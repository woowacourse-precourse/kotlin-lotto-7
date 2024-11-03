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
                matchingNumberCount == 6 -> FIRST
                matchingNumberCount == 5 && matchingBonusNumber -> SECOND
                matchingNumberCount == 5 -> THIRD
                matchingNumberCount == 4 -> FOURTH
                matchingNumberCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}