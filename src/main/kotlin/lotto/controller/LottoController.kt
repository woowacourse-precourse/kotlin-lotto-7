package lotto.controller

import lotto.domain.PurchaseMoney
import lotto.view.InputView

class LottoController {
    fun start() {
        val purchaseMoney = PurchaseMoney(InputView.inputPurchaseMoney())
        val winningNumbers = InputView.inputWinningNumber()
        val bonusNumber = InputView.inputBonusNumber()
    }
}