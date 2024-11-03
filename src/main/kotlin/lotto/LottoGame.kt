package lotto

import camp.nextstep.edu.missionutils.Randoms

const val TICKET_COST = 1000

class LottoGame(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    var ticketList = mutableListOf<Lotto>()
        private set

    fun buyTickets(payment: Int) {
        val ticketCount = payment / TICKET_COST
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
        ticketList.forEach { println(it.getNumbers().toString()) }
    }

    fun printWinningResults() {
        val winningResults = calculateWinningCounts()

        println("당첨 통계")
        println("---")
        println("3개 일치 (${LottoRank.FIFTH.prize}원) - ${winningResults[LottoRank.FIFTH.ordinal]}개")
        println("4개 일치 (${LottoRank.FOURTH.prize}원) - ${winningResults[LottoRank.FOURTH.ordinal]}개")
        println("5개 일치 (${LottoRank.THIRD.prize}원) - ${winningResults[LottoRank.THIRD.ordinal]}개")
        println("5개 일치, 보너스 볼 일치 (${LottoRank.SECOND.prize}원) - ${winningResults[LottoRank.SECOND.ordinal]}개")
        println("6개 일치 (${LottoRank.FIRST.prize}원) - ${winningResults[LottoRank.FIRST.ordinal]}개")
    }

    private fun calculateWinningCounts(): List<Int> {
        val winningCounts = mutableListOf(0, 0, 0, 0, 0, 0)
        ticketList.forEach {
            val rank = it.getLottoResultAsRank(winningNumbers, bonusNumber)
            winningCounts[rank.ordinal]++ // n등 -> winningResults[n]++
        }
        return winningCounts.toList()
    }

    fun printRatioOfProfit() {
        val profitRatio = calculateRatioOfProfit()
        val roundedProfitRatio = (profitRatio * 10).toInt() / 10f
        println("총 수익률은 ${roundedProfitRatio}입니다.")
    }

    private fun calculateRatioOfProfit(): Float {
        val winningCounts = calculateWinningCounts()
        val totalPrize = calculateTotalPrize(winningCounts)
        val totalCost = calculateTotalCost()

        return totalPrize.toFloat() / totalCost.toFloat()
    }

    private fun calculateTotalPrize(winningCounts: List<Int>): Int {
        var totalPrize = 0
        winningCounts.forEach {
            totalPrize += it * LottoRank.values()[it].prize
        }
        return totalPrize
    }

    private fun calculateTotalCost(): Int {
        return ticketList.size * TICKET_COST
    }

}