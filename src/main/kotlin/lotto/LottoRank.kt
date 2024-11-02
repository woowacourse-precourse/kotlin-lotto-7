package lotto

enum class LottoRank(
    val matchingCount: Int,
    val bonus: Boolean,
    val prize: Long,
    val description: String
) {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FORTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치")
}