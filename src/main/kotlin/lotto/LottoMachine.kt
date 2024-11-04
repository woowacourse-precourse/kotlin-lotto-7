package lotto

import lotto.utils.CalculateUtils
import lotto.utils.LottoGenerator

class LottoMachine(
    private val money: Int,
) {

    val lottoSet: List<Lotto> = createLottoSet(money)

    private fun createLottoSet(money: Int): List<Lotto> {
        val lottoCount = LottoGenerator.getLottoCount(money)
        val lottoSet = List(lottoCount) {
            Lotto(LottoGenerator.createLotto())
        }
        return lottoSet
    }

    fun getEarningsRate(winningNumber: List<Int>, bonusNumber: Int): String {
        val totalEarning = lottoSet.sumOf { it.getWinningRank(winningNumber, bonusNumber).price }
        val earningsRate = CalculateUtils.calculateEarningsRate(totalEarning, money)
        return earningsRate
    }

}