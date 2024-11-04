package lotto.model

import camp.nextstep.edu.missionutils.Randoms

fun randomNums(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1,45,6)
}

fun generateLottoTickets(count: Int): List<Lotto> {
    return List(count) { Lotto(randomNums()) }
}

fun calculateResults(lottoTickets: List<Lotto>, winNumbers: Set<Int>, bonusNumber: Int): Map<Prize, Int> {
    return lottoTickets
        .map { getRank(it, winNumbers, bonusNumber) }
        .filterNotNull()
        .groupingBy { it }
        .eachCount()
}

fun getRank(lotto: Lotto, winNumbers: Set<Int>, bonusNumber: Int): Prize? {
    val matchCount = lotto.getNumbers().count { it in winNumbers }
    val bonusMatch = bonusNumber in lotto.getNumbers()
    return Prize.getPrize(matchCount, bonusMatch)
}

fun calculateTotalPrize(results: Map<Prize, Int>): Int {
    return results.entries.sumOf { (prize, count) -> prize.money * count }
}