package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningStatus
import java.text.DecimalFormat

class LottoService {

    fun calculateQuantity(money: Int): Int = money / 1000

    fun generateLottos(quantity: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        for (i in 1..quantity) {
            val lotto = generateNumbers()
            lottos.add(lotto)
        }
        return lottos
    }

    private fun generateNumbers(): Lotto {
        return Randoms.pickUniqueNumbersInRange(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.LOTTO_NUMBER_SIZE)
            .sorted()
            .let { Lotto(it) }
    }

    fun checkWinning(
        lottos: List<Lotto>,
        winningNumbers: List<Int?>,
        bonusNumber: Int
    ): WinningStatus {
        val results = lottos.map { lotto ->
            val matchCount = lotto.getNumbers().count { it in winningNumbers }
            val matchBonus = bonusNumber in lotto.getNumbers()
            Rank.calculate(matchCount, matchBonus)
        }

        val rankCount = mutableMapOf<Rank, Int>()
        for (rank in Rank.entries) {
            rankCount[rank] = results.count { it == rank }
        }

        val profitRate = calculateProfitRate(results, lottos.size)

        return WinningStatus(rankCount, profitRate)
    }

    private fun calculateProfitRate(results: List<Rank>, amount: Int): Double {
        val totalPrize = results.sumOf { it.prize }
        val totalCost = amount * Lotto.PRICE
        return totalPrize.toDouble() / totalCost.toDouble() * 100
    }
}