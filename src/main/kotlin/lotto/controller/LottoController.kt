package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val lottoAmount = inputView.getLottoAmount()

        val lottoCount = lottoAmount / 1000
        outputView.printLottoAmountMessage(lottoCount)
    }

}