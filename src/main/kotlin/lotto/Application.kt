package lotto

import lotto.view.OutputView
import lotto.controller.LottoController
import lotto.model.message.ErrorMessage
import lotto.view.ErrorView

fun main() {
    try {
        val lottoController = LottoController()

        val purchaseAmount = lottoController.getNumbers()
        val tickets = lottoController.generateLottoTickets(purchaseAmount)

        OutputView.printLottoTickets(tickets)
    } catch (e: IllegalArgumentException) {
        ErrorView.errorMessage(e.message ?: ErrorMessage.DEFAULT_ERROR.message)
        throw e
    }
}
