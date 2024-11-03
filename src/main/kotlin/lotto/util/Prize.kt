package lotto.util

enum class Prize(val hit: Int, val rank: Int, val prize: Int, val bonus: Boolean) {
    FIRST(6, 1, 2000000000, false),
    SECOND(5, 2, 30000000, true),
    THIRD(5, 3, 15000000, false),
    FOURTH(4, 4, 50000, false),
    FIFTH(3, 5, 5000, false)
}