package lotto.model

class WinningCounter {
    private val winningCount = WinningCategory.entries.associateWith { 0 }.toMutableMap()

    fun increaseCount(category: WinningCategory) {
        winningCount[category] = winningCount.getOrDefault(category, 0) + 1
    }

    enum class WinningCategory {
        MATCH_THREE,
        MATCH_FOUR,
        MATCH_FIVE,
        MATCH_FIVE_BONUS,
        MATCH_SIX
    }
}