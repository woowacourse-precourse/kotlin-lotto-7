package lotto.model

enum class Rank(
    val index: Int,
    val matchedNumber: Int,
    val winningPrice: Int
) {
    NONE(0, 0, 0),
    FIFTH(1, 3, 5_000),
    FOURTH(2, 4, 50_000),
    THIRD(3, 5, 1_500_000),
    SECOND(4, 5, 30_000_000),
    FIRST(5, 6, 2_000_000_000),
}
