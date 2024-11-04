package lotto

enum class LottoResult(val prize: Int) {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_SPECIAL(30000000),
    SIX(2000000000)
}