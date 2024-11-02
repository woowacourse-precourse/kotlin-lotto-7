package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber
import lotto.domain.PurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun start() {
        val purchaseAmount = PurchaseAmount(InputView.inputPurchaseMoney())
        OutputView.printPurchaseAmount(purchaseAmount.getCount())
        val lottos = LottoGenerator().generateLottos(purchaseAmount.getCount())
        val winningNumbers = Lotto(InputView.inputWinningNumber())
        val bonusNumber = LottoNumber(InputView.inputBonusNumber())
    }
}