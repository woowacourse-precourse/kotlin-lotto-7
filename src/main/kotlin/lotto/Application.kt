package lotto

import lotto.controller.LottoController
import lotto.model.Cashier
import lotto.model.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val cashier = Cashier()
    val lottoMachine = LottoMachine()
    val inputView = InputView()
    val outputView = OutputView()
    val lottoController = LottoController(cashier, lottoMachine, inputView, outputView)
    lottoController.runLottoGame()
}
