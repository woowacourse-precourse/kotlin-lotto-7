package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants

class LottoGame {

    fun generateLotto(count: Int): List<Lotto> {
        val lotto = List(count) { Lotto(generateRandomNumbers()) }

        return lotto
    }

    private fun generateRandomNumbers(): List<Int> {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(
            Constants.MIN_NUMBER,
            Constants.MAX_NUMBER,
            Constants.WINNING_NUMBERS_COUNT
        )
        return randomNumbers
    }

    fun calculateResult(
        lottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): LottoResult {
        val prizeCounts = Prize.values().associateWith { 0 }.toMutableMap()
        var totalPrize = 0

    }

    private fun calculateMatch(
        lotto: Lotto,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Pair<Int, Boolean> {
        val matchCount = lotto.getNumbers().count { it in winningNumbers }
        val isBonusMatch = bonusNumber in lotto.getNumbers() && matchCount == 5
        val matchResult = Pair(matchCount, isBonusMatch)

        return matchResult
    }
}