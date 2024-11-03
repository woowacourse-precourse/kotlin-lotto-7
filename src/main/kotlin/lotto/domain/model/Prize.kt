package lotto.domain.model

enum class Prize(
    val matchingNumberCount: Int,
    val prizeAmount: Int,
) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

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