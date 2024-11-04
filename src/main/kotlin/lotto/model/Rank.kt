package lotto.model

enum class Rank(
    val index: Int,
    val matchedNumber: Int,
    val winningPrice: Long
) {
    NONE(0, 0, 0L),
    FIFTH(1, 3, 5_000L),
    FOURTH(2, 4, 50_000L),
    THIRD(3, 5, 1_500_000L),
    SECOND(4, 5, 30_000_000L),
    FIRST(5, 6, 2_000_000_000L),
}
