package lotto.controller

import lotto.model.lotto.LottoTicket
import lotto.view.InputView
import java.lang.IllegalArgumentException
import lotto.model.message.ErrorMessage
import lotto.view.OutputView

class LottoController {

    fun run() {
        val purchaseAmount = getPrice()
        val tickets = generateLottoTickets(purchaseAmount)

        OutputView.printLottoTickets(tickets)

        val winningNumbers = getWinningNumbers()
    }

    private fun generateLottoTickets(purchaseAmount: Int): List<LottoTicket> {
        require(purchaseAmount % 1000 == 0) { ErrorMessage.PURCHASE_PRICE_1000.message }
        val ticketCount = purchaseAmount / 1000

        val tickets = List(ticketCount) { LottoTicket.generate() }

        return tickets
    }

    private fun getPrice(): Int {
        val purchasePrice = InputView.askForPrice().toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_PRICE.message)
        return purchasePrice
    }

    private fun getWinningNumbers(): List<Int> {
        val purchasePrice = InputView.askWinningNumbers()
            .split(",")
            .map {
                val trimmed = it.trim()
                require(trimmed.isNotEmpty()) { ErrorMessage.INPUT_WINNING_EMPTY.message }
                trimmed.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.INPUT_WINNING_ONLY_NUMBERS.message)
            }
        require(purchasePrice.size == 6) { ErrorMessage.INPUT_WINNING_6_NUMBERS.message }
        return purchasePrice
    }

}