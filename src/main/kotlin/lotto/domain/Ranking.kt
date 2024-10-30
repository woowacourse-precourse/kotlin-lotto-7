package lotto.domain

enum class Ranking(val prize: Int, private val matchingMsg: String) {
    FIFTH(5_000, "3개 일치 (5,000원) - "), // 5등
    FOURTH(50_000, "4개 일치 (50,000원) - "), // 4등
    THIRD( 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    SECOND( 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원) - "); // 1등


    fun formattedMsg(): String {
        return matchingMsg
    }
}
