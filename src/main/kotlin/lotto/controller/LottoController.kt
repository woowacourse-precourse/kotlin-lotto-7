package lotto.controller

import lotto.view.InputView

class LottoController {
    private val inputView = InputView()

    fun start() {
        val lottoAmount = inputView.getLottoAmount()

        val lottoCount = lottoAmount / 1000
    }

}