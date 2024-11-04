package lotto


fun main() {
    val money = inputMoney()
    val ticketCount = calculateTicket(money)
    println("${ticketCount}개를 구매했습니다.")

    val lottoNum = inputLottoNumbers()
    val bonusNum = inputBonusNumber(lottoNum)

    val tickets = generateLotto(ticketCount)
    tickets.forEach { println(it.getNumbers().sorted()) }

    val statistics = calculateWin(tickets,lottoNum,bonusNum)
    printStatistics(statistics,money)

}


fun calculateTicket(money: Int): Int {
    return money / 1000
}

fun generateLotto(ticketsCount : Int) : List<Lotto> {
    return List(ticketsCount) { Lotto(Lotto.generateLotto()) }
}

fun calculateWin(tickets: List<Lotto>, winNumber: List<Int> , bonusNum: Int) : Map<String,Int> {
    val statistics = mutableMapOf("1등" to 0, "2등" to 0, "3등" to 0, "4등" to 0, "5등" to 0)

    tickets.forEach { lottoTicket ->
        val matchCount = lottoTicket.lottoMatches(winNumber)
        val bonusMatch = lottoTicket.isBonusMatches(bonusNum)

        when (matchCount) {
            6 -> statistics["1등"] = statistics.getValue("1등") + 1
            5 -> if (bonusMatch) statistics["2등"] = statistics.getValue("2등") + 1
            else statistics["3등"] = statistics.getValue("3등") + 1
            4 -> statistics["4등"] = statistics.getValue("4등") + 1
            3 -> statistics["5등"] = statistics.getValue("5등") + 1
        }
    }
    return statistics
}

fun printStatistics(statistics: Map<String,Int>, spendMoney : Int) {
    println("\n당첨 통계\n---")
    println("3개 일치 (5,000원) - ${statistics["5등"]}개")
    println("4개 일치 (50,000원) - ${statistics["4등"]}개")
    println("5개 일치 (1,500,000원) - ${statistics["3등"]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${statistics["2등"]}개")
    println("6개 일치 (2,000,000,000원) - ${statistics["1등"]}개")

    val profitRate = calculateProfitRate(statistics, spendMoney)
    println("총 수익률은 ${String.format("%.1f", profitRate)}%입니다.")
}

fun calculateProfitRate(statistics: Map<String, Int>, ticketCost : Int) : Double {
    val prizeMoney = mapOf("1등" to 2_000_000_000, "2등" to 30_000_000,
        "3등" to 1_500_000, "4등" to 50_000, "5등" to 5_000
    )
    val totalPrize = statistics.entries.sumOf { (rank,count) ->
        prizeMoney.getOrDefault(rank,0) * count
    }

    val profitRate = (totalPrize.toDouble() / ticketCost) * 100

    return Math.round(profitRate * 100) / 100.0
}
