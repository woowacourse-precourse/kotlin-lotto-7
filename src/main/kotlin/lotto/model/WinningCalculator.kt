package lotto.model

import lotto.util.Prize


class WinningCalculator {
    fun calculateDetails(winningLotto: Lotto, bonus: Int, lottoes: List<Lotto>): MutableList<Int> {
        var winningDetails = mutableListOf(0, 0, 0, 0, 0)
        for (purchasedLotto in lottoes) {
            winningDetails = calculateDetail(purchasedLotto, winningLotto, bonus, winningDetails)
        }
        return winningDetails
    }

    private fun calculateDetail(
        purchasedLotto: Lotto,
        winningLotto: Lotto,
        bonus: Int,
        winningDetails: MutableList<Int>
    ): MutableList<Int> {
        val union = purchasedLotto.getNumbers() + winningLotto.getNumbers()
        val matchCount = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct().size
        when {
            matchCount == 6 -> winningDetails[0]++
            matchCount == 5 && purchasedLotto.getNumbers().contains(bonus) -> winningDetails[1]++
            matchCount == 5 -> winningDetails[2]++
            matchCount == 4 -> winningDetails[3]++
            matchCount == 3 -> winningDetails[4]++
        }
        return winningDetails
    }

    fun calculateReturnRate(money: Int, winningDetails: MutableList<Int>): Double {
        return calculatePrize(winningDetails).toDouble() / money.toDouble() * 100
    }

    private fun calculatePrize(winningDetails: MutableList<Int>): Int {
        var total = 0
        val prize = Prize.entries
        for ((index, count) in winningDetails.withIndex()) {
            total += prize.find { it.rank == index + 1 }!!.prize * count
        }
        return total
    }
}