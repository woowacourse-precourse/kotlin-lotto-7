package view

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

    fun printTickets(tickets: List<List<Int>>) {
        for (ticket in tickets) {
            println("["+ticket.joinToString()+"]")
        }
    }
}