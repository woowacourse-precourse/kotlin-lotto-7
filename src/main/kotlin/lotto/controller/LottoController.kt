package lotto.controller

import lotto.Lotto
import lotto.model.LottoIssuance
import lotto.model.Processor
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun draw() {
        val money = getMoney()

        val lottoIssuance= LottoIssuance(money)

        val winningNum = getWinningNNum()
        val bonusNum = getBonusNum()
        val lotto = Lotto(winningNum)

        val matchNum = lotto.compLottoList(lottoIssuance.lottoList, bonusNum)
        val yields = lotto.calcutateYields(matchNum, money)
        OutputView.printResult(matchNum, yields)
    }

    private fun getMoney(): Int {
        while (true) {
            try {
                val money = Processor.moneyProcess(InputView.getMoney().toIntOrNull())
                return money
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getWinningNNum(): List<Int> {
        while (true) {
            try {
                val winningNum = Processor.winningNumSplit(InputView.getWinningNumber())
                return winningNum
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getBonusNum(): Int {
        while (true) {
            try {
                val bonusNum = Processor.bonusNumValidate(InputView.getBonusNumber().toIntOrNull())
                return bonusNum
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}