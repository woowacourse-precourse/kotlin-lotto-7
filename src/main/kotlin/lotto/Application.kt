package lotto

import lotto.controller.LottoController
import lotto.model.LottoCalculator
import lotto.model.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoCalculator = LottoCalculator()
    val lottoMachine = LottoMachine()
    val inputView = InputView()
    val outputView = OutputView()
    val lottoController = LottoController(lottoCalculator, lottoMachine, inputView, outputView)
    lottoController.runLottoGame()
}
