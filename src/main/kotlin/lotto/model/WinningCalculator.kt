package lotto.model

import lotto.util.Prize


class WinningCalculator {
    fun calculateDetails(winningLotto: Lotto, bonus: Int, lottoes: List<Lotto>): List<Int> {
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
        var count = 0
        purchasedLotto.getNumbers().forEach {
            if (winningLotto.getNumbers().contains(it)) {
                count++
            }
        }
        when {
            count == 3 -> winningDetails[4]++
            count == 4 -> winningDetails[3]++
            count == 5 && winningLotto.getNumbers().contains(bonus) -> winningDetails[2]++
            count == 5 -> winningDetails[1]++
            count == 6 -> winningDetails[0]++
        }
        return winningDetails
    }

    fun calculateReturnRate(money:Int,winningDetails: MutableList<Int>) : Double {
        return calculatePrize(winningDetails).toDouble() / money.toDouble() * 100
    }

    fun calculatePrize(winningDetails: MutableList<Int>):Int{
        var total = 0
        val prize = Prize.entries
        for ((index,count) in winningDetails.withIndex()){
            total += prize.find { it.rank == index+1 }!!.prize * count
        }
        return total
    }
}