package lotto

enum class LottoMatchType(val matchCount: Int, val reward: String, val description: String) {
    THREE(3, "5,000원", "3개 일치"),
    FOUR(4, "50,000원", "4개 일치"),
    FIVE(5, "1,500,000원", "5개 일치"),
    FIVE_BONUS(5, "30,000,000원", "5개 일치, 보너스 볼 일치"),
    SIX(6, "2,000,000,000원", "6개 일치");

    override fun toString(): String = "$description ($reward)"
}