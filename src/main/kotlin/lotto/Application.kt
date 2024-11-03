package lotto

fun main() {
    val money = inputMoney()
    val tickets = calculateTicket(money)
    println("$tickets 개를 구매했습니다.")
    val lottoNum = inputLottoNumbers()

    val bonusNum = inputBonusNumber(lottoNum)

    repeat(tickets) {
        generateLotto(tickets)
    }

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
