package lotto

import lotto.utils.CalculateUtils
import lotto.utils.LottoGenerator

class LottoMachine(
    private val money: Int,
) {

    val lottoSet: List<Lotto> = createLottoSet(money)
    var winningRankSet: List<WinningRank> = emptyList()
        private set

    private fun createLottoSet(money: Int): List<Lotto> {
        val lottoCount = LottoGenerator.getLottoCount(money)
        val lottoSet = List(lottoCount) {
            Lotto(LottoGenerator.createLotto())
        }
        return lottoSet
    }

    fun updateWinningNumber(winningNumber: List<Int>, bonusNumber: Int) {
        winningRankSet = lottoSet.map { lotto ->
            lotto.getWinningRank(winningNumber, bonusNumber)
        }
    }

    fun getEarningsRate(): String {
        val totalEarning = winningRankSet.sumOf { it.price }
        val earningsRate = CalculateUtils.getEarningsRate(totalEarning, money)
        return earningsRate
    }

}