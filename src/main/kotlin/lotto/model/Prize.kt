package lotto.model

enum class Prize(count: Int, money: Int, val description: String) {
    hitThree(3, 5000, "3개 일치"),
    hitFour(4, 50000, "4개 일치"),
    hitFive(5, 1500000, "5개 일치"),
    hitFiveBonus(5, 30000000, "5개 일치, 보너스 볼 일치"),
    hitSix(6, 2000000000, "6개 일치");

    companion object {
        fun getPrize(matchCount: Int, bonusMatch: Boolean): Prize? {
            return when (matchCount) {
                6 -> hitSix
                5 -> if (bonusMatch) hitFiveBonus else hitFive
                4 -> hitFour
                3 -> hitThree
                else -> null
            }
        }
    }
}