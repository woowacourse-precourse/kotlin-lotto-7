package lotto

enum class LottoRank(val winNumbersCount: Int) {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    LOSE(2)
}