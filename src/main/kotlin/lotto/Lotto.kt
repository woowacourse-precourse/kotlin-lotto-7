package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

class Lotto(private val numbers: List<Int>) {

    fun runAndGetResult() {

    }

    fun buyTickets(payment: Int): List<List<Int>> {
        val ticketCount = payment / 1000
        val ticketList = mutableListOf<List<Int>>()
        for (i in 0 until ticketCount) {
            val ticket = generateTicketRandomly()
            val sortedTicket = sortTicketAscend(ticket)
            ticketList.add(sortedTicket)
        }

        return ticketList.toList()
    }

    private fun generateTicketRandomly(): List<Int> {
        return pickUniqueNumbersInRange(1, 45, 6)
    }

    private fun sortTicketAscend(ticket: List<Int>): List<Int> {
        return ticket.sorted()
    }


}
