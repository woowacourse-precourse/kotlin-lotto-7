package lotto

enum class LottoRank(val price: Int, val count: Int, val rank: String) {
    FIRST(2000000000, 6, "1등"),
    SECOND(30000000, 5, "2등"),
    THIRD(1500000, 5, "3등"),
    FOURTH(50000, 4, "4등"),
    FIFTH(5000, 3, "5등"),
}