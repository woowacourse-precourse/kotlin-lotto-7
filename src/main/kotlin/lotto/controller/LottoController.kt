package lotto.controller

import lotto.domain.GameResult
import lotto.domain.LottoGenerator
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun start() {
        val purchaseAmount = InputView.inputPurchaseMoney()
        OutputView.printPurchaseAmount(purchaseAmount.getCount())

        val lottos = List(purchaseAmount.getCount()) { LottoGenerator().generate() }
        lottos.forEach { OutputView.printLottoNumbers(it) }

        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber()
        val winningNumber = WinningNumber(winningNumbers.getNumbers(), bonusNumber)

        val gameResult = GameResult()
        for (lotto in lottos) {
            val rank = winningNumber.getRank(lotto)
            gameResult.addWinningDetail(rank)
        }
    }
}