package lotto.controller

import lotto.domain.Lotto
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {
    fun run() {
        val purchaseAmount = getValidPurchaseAmount()
        val lottoCount = purchaseAmount / 1_000
        val lottos = generateLottos(lottoCount)
        val winningLotto = getVaildWinningLotto()
        OutputView.printPurchasedLottos(lottos)
    }

    private fun getValidPurchaseAmount(): Int {
        while (true) {
            try {
                val amount = InputView.getPurchaseAmount()
                require(amount % 1_000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
    private fun generateLottos(count: Int): List<Lotto> {
        return List(count) { Lotto() }
    }

    private fun getVaildWinningLotto() : WinningLotto {
        while (true) {
            try {
                val winningNumbers = InputView.getWinningNumbers()
                return WinningLotto(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}