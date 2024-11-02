package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.PurchaseMoney
import lotto.view.InputView

class LottoController {
    fun start() {
        val purchaseMoney = PurchaseMoney(InputView.inputPurchaseMoney())
        val winningNumbers = Lotto(InputView.inputWinningNumber())
        val bonusNumber = LottoNumber(InputView.inputBonusNumber())
    }
}