package lotto

import lotto.controller.LottoController

fun main() {
    val cashier = Cashier()
    val lottoMachine = LottoMachine()
    val lottoController = LottoController(cashier, lottoMachine)
    lottoController.start()
}
