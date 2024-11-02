package lotto.controller

import lotto.Lotto
import lotto.model.LottoIssuance
import lotto.model.Processor
import lotto.view.InputView

class LottoController {
    fun draw() {
        val money = Processor.moneyProcess(InputView.getMoney().toInt())

        val lottoIssuance: LottoIssuance = LottoIssuance(money)

        val winningNum = Processor.winningNumSplit(InputView.getWinningNumber())
        val bonusNum = InputView.getBonusNumber()

        val lotto = Lotto(winningNum)
    }
}