package lotto

//당첨 등수 및 상금 정의
enum class Prize(
    val matchCount: Int,
    val prizeMoney: Int,
    val requiresBonus: Boolean = false // 해당 등수에 보너스 번호 일치가 필요한지 여부
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, requiresBonus = true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    companion object {
        // Prize 등수를 찾아 반환
        fun getPrize(matchCount: Int, bonusMatch: Boolean): Prize? {
            return values().find { it.matchCount == matchCount && (!it.requiresBonus || bonusMatch) }
        }
    }
}