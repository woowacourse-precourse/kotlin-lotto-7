package lotto

import lotto.controller.LottoController

fun main() {
    val cashier = Cashier()
    val lottoMachine = LottoMachine()
    val inputView = InputView()
    val lottoController = LottoController(cashier, lottoMachine, inputView)
    lottoController.start()
}
