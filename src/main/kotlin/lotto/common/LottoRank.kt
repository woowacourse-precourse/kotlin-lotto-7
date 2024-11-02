package lotto.common

enum class LottoRank(val price: Int, val matchCount: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    // 6등은 matchCount가 의미가 없어서 0으로 구현
    SIXTH(0, 0);
}