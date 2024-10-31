package lotto.controller

import lotto.view.InputView

class LottoController {
    fun run() {
        val inputView = InputView()
        val lottoMoney = inputView.readLottoMoney()
    }
}
