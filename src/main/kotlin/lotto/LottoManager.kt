package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoManager {
    fun buyTickets(payment: Int): List<List<Int>> {
        val ticketCount = payment / 1000
        val ticketList = mutableListOf<List<Int>>()
        for (i in 0 until ticketCount) {
            val ticket = generateTicketRandomly()
            val sortedTicket = ticket.sorted()
            ticketList.add(sortedTicket)
        }

        return ticketList.toList()
    }

    private fun generateTicketRandomly(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}