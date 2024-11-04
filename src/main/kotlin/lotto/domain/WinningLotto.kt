package lotto.domain

import lotto.Lotto

class WinningLotto(
    numbers: List<Int>,
    private val bonusNumber: Int,
) {
    private val lotto: Lotto

    init {
        require(!numbers.contains(bonusNumber)) { sendError(WINNING_UNIQUE_NUMBER_ERROR) }
        require(bonusNumber in Lotto.MINIMUM_NUMBER..Lotto.MAXIMUM_NUMBER) { sendError(WINNING_NUMBER_RANGE_ERROR) }
        this.lotto = Lotto(numbers)
    }

    fun match(userLotto: Lotto): Rank {
        val matchCount = lotto.matchCount(userLotto)
        val hasBonusMatch = matchCount == 5 && userLotto.contains(bonusNumber)
        return Rank.of(matchCount, hasBonusMatch)
    }

    fun getWinningNumbers(): List<Int> = lotto.getSortedNumbers()

    fun getBonusNumber(): Int = bonusNumber

    companion object {
        private const val ERROR_PREFIX = "[ERROR] "
        const val WINNING_UNIQUE_NUMBER_ERROR = "보너스 번호는 당첨 번호와 중복될 수 없습니다."
        const val WINNING_NUMBER_RANGE_ERROR = "보너스 번호는 1부터 45 사이의 숫자여야 합니다."

        fun sendError(message: String): String = ERROR_PREFIX + message
    }
}
