package lotto

import camp.nextstep.edu.missionutils.Randoms


class LottoGame {
    var ticketList = mutableListOf<List<Int>>()
    var

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

    fun printTicketList(ticketList: List<List<Int>>) {
        println("${ticketList.size}개를 구매했습니다.")
        ticketList.forEach { it -> println(it.toString()) }
    }

    fun printWinningResults(lotto: Lotto) {

    }
}