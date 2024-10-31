package lotto.controller

import lotto.model.lotto.LottoTicket
import lotto.view.InputView
import java.lang.IllegalArgumentException
import lotto.model.message.ErrorMessage
import lotto.view.OutputView

class LottoController {

    fun run() {
        val purchaseAmount = getNumbers()
        val tickets = generateLottoTickets(purchaseAmount)

        OutputView.printLottoTickets(tickets)
    }

    fun generateLottoTickets(purchaseAmount: Int): List<LottoTicket> {
        require(purchaseAmount % 1000 == 0) { ErrorMessage.PURCHASE_PRICE_1000.message }
        val ticketCount = purchaseAmount / 1000

        val tickets = List(ticketCount) { LottoTicket.generate() }

        return tickets
    }

    fun getNumbers(): Int {
        val purchasePrice = InputView.askForPrice().toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_PRICE.message)
        return purchasePrice
    }
}