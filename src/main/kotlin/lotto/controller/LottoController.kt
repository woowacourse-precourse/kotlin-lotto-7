package lotto.controller

import lotto.view.InputView

object LottoController {
    fun run() {
        val purchaseAmount = getValidPurchaseAmount()

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
}