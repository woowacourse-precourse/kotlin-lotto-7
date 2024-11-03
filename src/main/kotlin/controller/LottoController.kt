package controller

import model.Lotto
import model.LottoMachine
import model.Prize
import model.WinningLotto
import view.InputView
import view.OutputView

/* LottoController 설계
* 1. 구입 금액 입력
* 2. 구매 개수 출력
* 3. 로또 번호 생성
* 4. 로또 번호 출력
* 5. 당첨 번호 입력
* 6. 보너스 번호 입력
* 7. 당첨 통계 계산
* 8. 당첨 결과 출력
*
* */
class LottoController {

    fun playLottoGame() {
        val money = InputView.getMoney()
        val lottoCount = money / DECIMAL

        val lottoes = LottoMachine.issueLottoes(lottoCount)

        OutputView.printLotto(lottoCount, lottoes)

        val winningLotto = getWinningLotto()
        calculatePrize(lottoes, winningLotto)

        OutputView.printWinningStatistics()

        val earningMoney = calculateEarningMoney()

        val earningRate = getEarningRate(earningMoney, money)

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
            6 -> {
                Prize.FIRST.plusCount()
            }

            5 -> {
                if (matchBonus) {
                    Prize.SECOND.plusCount()
                }
                Prize.THIRD.plusCount()
            }

            4 -> {
                Prize.FOURTH.plusCount()
            }

            3 -> {
                Prize.FIFTH.plusCount()
            }
        }
    }

    fun calculateEarningMoney(): Int {
        return Prize.entries.sumOf { it.prize * it.winningCount }
    }

    fun getEarningRate(earningMoney: Int, money: Int): Double {
        return earningMoney.toDouble() / money * 100
    }

    companion object {
        const val DECIMAL = 1000
    }

}