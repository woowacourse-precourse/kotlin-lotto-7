package lotto

data class Prize(
    var first: Int = 0,
    var second: Int = 0,
    var third: Int = 0,
    var forth: Int = 0,
    var fifth: Int = 0,
    var miss: Int = 0,
) {
    fun countPrize(rank: Rank) {
        when (rank.winningCount) {
            Rank.FIRST_RANK.winningCount -> first++
            Rank.SECOND_RANK.winningCount -> second++
            Rank.THIRD_RANK.winningCount -> third++
            Rank.FOURTH_RANK.winningCount -> forth++
            Rank.FIFTH_RANK.winningCount -> fifth++
            else -> miss++
        }
    }
    
}
