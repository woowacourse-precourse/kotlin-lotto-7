package lotto.domain

import lotto.model.Lotto
import camp.nextstep.edu.missionutils.Randoms
import lotto.model.WinningCounter
import lotto.model.WinningCounter.WinningCategory.*

class GameService {
    fun buyLottos(money: Long): List<Lotto> {
        val lottoAmount = (money / ONE_LOTTO_PRICE).toInt()

        return List(lottoAmount) { generateLotto() }
    }

    private fun generateLotto(): Lotto {
        val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        lottoNumbers.sort()

        return Lotto(lottoNumbers)
    }

    fun countWinnings(boughtLottos: List<Lotto>, winNumbers: Lotto, bonusNumber: Int): WinningCounter {
        val winningCount = WinningCounter()
        boughtLottos.forEach { myLotto ->
            val matchingCount = myLotto.numbers().count { it in winNumbers.numbers() }
            val isBonusMatch = bonusNumber in myLotto.numbers()
            when {
                matchingCount == 6 -> winningCount.increaseCount(MATCH_SIX)
                matchingCount == 5 && isBonusMatch -> winningCount.increaseCount(MATCH_FIVE_BONUS)
                matchingCount == 5 -> winningCount.increaseCount(MATCH_FIVE)
                matchingCount == 4 -> winningCount.increaseCount(MATCH_FOUR)
                matchingCount == 3 -> winningCount.increaseCount(MATCH_THREE)
            }
        }

        return winningCount
    }

    fun calculateReturnRate(countWinnings: WinningCounter, money: Long): String {
        val returnRate = (countWinnings.totalPrizeSum().toDouble() / money) * 100
        return String.format("%.1f%%", returnRate)
    }

    companion object {
        const val ONE_LOTTO_PRICE = 1000
    }
}