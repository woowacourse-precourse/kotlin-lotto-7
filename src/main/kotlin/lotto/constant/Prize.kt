package lotto.constant

enum class Prize(val money: Int, val match: Int, val isBonus: Boolean = false) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5),
    FORTH(50_000, 4),
    FIFTH(5_000, 3),
}
