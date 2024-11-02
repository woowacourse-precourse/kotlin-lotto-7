package lotto

enum class LottoMatchingCount(var count: Int, val prize: Double, val message: String) {
    FIFTH(0, 5000.0, LottoInfo.FIFTH),
    FOURTH(0, 50000.0, LottoInfo.FOURTH),
    THIRD(0, 1500000.0, LottoInfo.THIRD),
    SECOND(0, 30000000.0, LottoInfo.SECOND),
    FIRST(0, 2000000000.0, LottoInfo.FIRST),
    NONE(0, 0.0, "")
}

object LottoInfo {
    const val FIRST = "6개 일치 (2,000,000,000원) - "
    const val SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    const val THIRD = "5개 일치 (1,500,000원) - "
    const val FOURTH = "4개 일치 (50,000원) - "
    const val FIFTH = "3개 일치 (5,000원) - "
}