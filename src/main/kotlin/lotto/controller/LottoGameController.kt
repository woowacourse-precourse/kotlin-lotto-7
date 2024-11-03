package lotto.controller

import lotto.view.LottoGameView

class LottoGameController(
    private val lottoGameView: LottoGameView
) {
    fun start() {
        val purchaseAmount: Int = lottoGameView.getPurchaseAmount()
    }
}
