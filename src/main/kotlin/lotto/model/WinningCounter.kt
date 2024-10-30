package lotto.model

class WinningCounter {
    private val winningCounts = WinningCategory.entries.associateWith { 0 }.toMutableMap()

    fun increaseCount(category: WinningCategory) {
        winningCounts[category] = winningCounts.getOrDefault(category, 0) + 1
    }

    fun inOrderNumbers(): List<Int> {
        return WinningCategory.entries.map { winningCounts.getOrDefault(it, 0) }
    }

    enum class WinningCategory {
        MATCH_THREE,
        MATCH_FOUR,
        MATCH_FIVE,
        MATCH_FIVE_BONUS,
        MATCH_SIX
    }
}