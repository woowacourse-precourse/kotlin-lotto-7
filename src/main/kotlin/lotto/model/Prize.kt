package lotto.model

enum class Prize(val money: Int, val moneyString: String, val description: String) {
    hitThree(5000, "5,000", "3개 일치"),
    hitFour(50000, "50,000", "4개 일치"),
    hitFive(1500000, "1,500,000", "5개 일치"),
    hitFiveBonus(30000000, "30,000,000", "5개 일치, 보너스 볼 일치"),
    hitSix(2000000000, "2,000,000,000", "6개 일치");

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
