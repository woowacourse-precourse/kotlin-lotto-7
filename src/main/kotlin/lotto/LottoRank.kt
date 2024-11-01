package lotto

enum class LottoRank(val price: Int) {
    NOTHING(0),
    THREE_MATCHES(5000),
    FOUR_MATCHES(50000),
    FIVE_MATCHES(1500000),
    FIVE_AND_BONUS_MATCHES(30000000),
    SIX_MATCHES(2000000000)
}

fun Int.toLottoRank(): LottoRank =
    when (this) {
        3 -> LottoRank.THREE_MATCHES
        4 -> LottoRank.FOUR_MATCHES
        5 -> LottoRank.FIVE_MATCHES
        55 -> LottoRank.FIVE_AND_BONUS_MATCHES
        6 -> LottoRank.SIX_MATCHES
        else -> LottoRank.NOTHING
    }