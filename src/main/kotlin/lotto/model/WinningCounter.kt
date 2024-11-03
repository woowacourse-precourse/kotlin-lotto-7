package lotto.model

class WinningCounter {
    private val winningCounts = WinningCategory.entries.associateWith { 0 }.toMutableMap()

    fun increaseCount(category: WinningCategory) {
        winningCounts[category] = winningCounts.getOrDefault(category, 0) + 1
    }

    fun inOrderNumbers(): List<Int> {
        return WinningCategory.entries.map { winningCounts.getOrDefault(it, 0) }
    }

    fun totalPrizeSum(): Long {
        return winningCounts.entries.sumOf { (category, count) -> category.prize * count }
    }

    enum class WinningCategory(val prize: Long) {
        MATCH_THREE(5_000L),
        MATCH_FOUR(50_000L),
        MATCH_FIVE(1_500_000L),
        MATCH_FIVE_BONUS(30_000_000L),
        MATCH_SIX(2_000_000_000L)
    }
}