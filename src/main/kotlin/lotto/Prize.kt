package lotto

data class Prize(
    var first: Int = 0,
    var second: Int = 0,
    var third: Int = 0,
    var fourth: Int = 0,
    var fifth: Int = 0,
) {
    fun countPrize(rank: Rank) {
        when (rank) {
            Rank.FIRST_RANK -> first++
            Rank.SECOND_RANK -> second++
            Rank.THIRD_RANK -> third++
            Rank.FOURTH_RANK -> fourth++
            Rank.FIFTH_RANK -> fifth++
        }
    }

}
