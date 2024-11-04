package controller

import model.Lotto
import model.LottoMachine
import model.Prize
import model.WinningLotto
import view.InputView
import view.OutputView

class LottoController {

    fun playLottoGame() {
        val money = InputView.getMoney()
        val lottoCount = money / DECIMAL

        val lottoes = LottoMachine.issueLottoes(lottoCount)
        OutputView.printLotto(lottoCount, lottoes)

        val winningLotto = getWinningLotto()
        calculatePrize(lottoes, winningLotto)
        OutputView.printWinningStatistics()

        val earningRate = getEarningRate(money)
        OutputView.printEarningRate(earningRate)
    }

    private fun getWinningLotto(): WinningLotto {
        val winningNumbers = InputView.getWinningNumbers()

        val bonusNumber = InputView.getBonusNumber(winningNumbers)

        return WinningLotto(
            Lotto(winningNumbers), bonusNumber
        )
    }

    fun calculatePrize(lottoes: List<Lotto>, winningLotto: WinningLotto) {

        lottoes.map { lotto ->
            val matchCount = lotto.matchCount(winningLotto)
            val isMatchBonus = lotto.isMatchBonus(winningLotto)

            updatePrize(matchCount, isMatchBonus)
        }
    }

    fun updatePrize(matchCount: Int, matchBonus: Boolean) {
        when (matchCount) {
            6 -> Prize.FIRST.plusCount()
            5 -> {
                if (matchBonus) {
                    Prize.SECOND.plusCount()
                    return
                }
                Prize.THIRD.plusCount()
            }

            4 -> Prize.FOURTH.plusCount()
            3 -> Prize.FIFTH.plusCount()
        }
    }

    private fun calculateEarningMoney(): Int {
        return Prize.entries.sumOf { it.prize * it.winningCount }
    }

    fun getEarningRate(money: Int): Double {
        val earningMoney = calculateEarningMoney()
        return earningMoney.toDouble() / money * 100
    }

    companion object {
        const val DECIMAL = 1000
    }

}