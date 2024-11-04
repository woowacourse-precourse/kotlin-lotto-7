package view

import model.Lotto
import model.LottoTickets
import utils.PrintUtils

object OutputView {
    fun printMoneyMessage() {
        println(PrintUtils.ENTER_MONEY)
    }

    fun printExceptionMessage(message: String) {
        println(message)
    }

    fun newLine() {
        println()
    }

    fun printTicketCounts(ticketCounts: Int) {
        println("$ticketCounts"+PrintUtils.LOTTO_TICKET_COUNTS)
    }

    fun printTickets(ticket: String) {
        println("[$ticket]")
    }

    fun printWinNumberMessage() {
        println(PrintUtils.ENTER_WIN_NUMBERS)
    }
}