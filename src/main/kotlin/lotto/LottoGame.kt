package lotto

import camp.nextstep.edu.missionutils.Randoms


class LottoGame {
    private var ticketList = mutableListOf<Lotto>()

    fun buyTickets(payment: Int) {
        val ticketCount = payment / 1000
        for (i in 0 until ticketCount) {
            val ticket = generateTicketRandomly()
            ticketList.add(ticket)
        }
    }

    private fun generateTicketRandomly(): Lotto {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val sortedNumbers = randomNumbers.sorted()
        return Lotto(sortedNumbers)
    }

    fun printTicketList() {
        println("${ticketList.size}개를 구매했습니다.")
        ticketList.forEach { it -> println(it.getNumbers().toString()) }
    }

    fun printWinningResults() {

    }
}