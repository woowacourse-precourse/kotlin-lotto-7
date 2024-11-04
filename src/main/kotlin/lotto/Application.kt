package lotto

import lotto.controller.LottoController
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

fun main() {
    val inputView = LottoInputView()
    val outputView = LottoOutputView()
    val lottoController = LottoController(inputView, outputView)

    lottoController.start()
}
