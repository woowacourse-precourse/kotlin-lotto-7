package lotto.controller

import lotto.domain.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun start() {
        val purchaseAmount = InputView.inputPurchaseMoney()
        OutputView.printPurchaseAmount(purchaseAmount.getCount())

        val lottos = LottoGenerator().generateLottos(purchaseAmount.getCount())
        OutputView.printLottos(lottos)

        val winningNumbers = InputView.inputWinningNumber()
        val bonusNumber = InputView.inputBonusNumber()
    }
}