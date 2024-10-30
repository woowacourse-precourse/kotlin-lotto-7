package lotto.domain

import lotto.ui.InputView

class LottoMachine(
    private val inputView: InputView
) {
    fun start() {
        val buildLottoAmount = inputView.buildLottoAmount()
    }
}