package lotto.controller

import lotto.Constants
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val lottoAmount = inputView.getLottoAmount()

        val lottoCount = lottoAmount / Constants.LOTTO_PRICE
        outputView.printLottoAmountMessage(lottoCount)
    }

}