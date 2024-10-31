package lotto

import lotto.view.OutputView
import lotto.controller.LottoController

fun main() {

    try {
        val lottoController = LottoController()

        val purchaseAmount = lottoController.getNumbers()
        val tickets = lottoController.generateLottoTickets(purchaseAmount)

        OutputView.printLottoTickets(tickets)
    } catch (e: IllegalArgumentException) {
        throw e
    }
}
