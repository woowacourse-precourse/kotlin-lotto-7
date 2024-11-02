package lotto.controller

import lotto.domain.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun start() {
        val purchaseAmount = InputView.inputPurchaseMoney()
        OutputView.printPurchaseAmount(purchaseAmount.getCount())

        val lottos = List(purchaseAmount.getCount()) { LottoGenerator().generate() }
        lottos.forEach { OutputView.printLottoNumbers(it) }

        val winningNumbers = InputView.inputWinningNumber()
        val bonusNumber = InputView.inputBonusNumber()
    }
}