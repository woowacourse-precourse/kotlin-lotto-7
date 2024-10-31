package lotto

import lotto.view.OutputView
import lotto.controller.LottoController
import lotto.view.ErrorView

fun main() {

    try {
        val lottoController = LottoController()

        val purchaseAmount = lottoController.getNumbers()
        val tickets = lottoController.generateLottoTickets(purchaseAmount)

        OutputView.printLottoTickets(tickets)
    } catch (e: IllegalArgumentException) {
        ErrorView.errorMessage(e.message ?: "오류가 발생했습니다.")
        throw e
    }
}
