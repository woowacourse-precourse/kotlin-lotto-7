package lotto.controller

import lotto.Lotto
import lotto.model.LottoIssuance
import lotto.model.Processor
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun draw() {
        val money = Processor.moneyProcess(InputView.getMoney().toInt())

        val lottoIssuance: LottoIssuance = LottoIssuance(money)

        val winningNum = Processor.winningNumSplit(InputView.getWinningNumber())
        val bonusNum = InputView.getBonusNumber().toInt()
        val lotto = Lotto(winningNum)

        val matchNum = lotto.compLottoList(lottoIssuance.lottoList, bonusNum)
        val yields = lotto.calcutateYields(matchNum, money)
        OutputView.printResult(matchNum, yields)
    }
}