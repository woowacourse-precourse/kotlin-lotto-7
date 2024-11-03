package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.roundToInt

class LottoShop() {
    private val soldLottoNumber = ArrayList<List<Int>>()
    private val lottos = ArrayList<Lotto>()
    private var winNumber = listOf(0)

    fun sellLotto(need: Int): ArrayList<List<Int>> {
        for (i in 1..need) {
            lottos.add(makeLotto())
            soldLottoNumber.add(lottos[i-1].getLottoNumber())
        }
        return soldLottoNumber
    }

    private fun makeLotto(): Lotto{
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        numbers.sort()
        return Lotto(numbers)
    }

    fun setWinNumber(winNumbers: List<Int>) {
        winNumber = winNumbers
    }

    fun getWinNumber(): List<Int> {
        return winNumber
    }

    fun winLotto(bonusNumber: Int): Pair<List<Int>, Double> {
        val wins = ArrayList<WinCondition>()
        for (i in 0..lottos.lastIndex) {
            wins.add(lottos[i].winConditionCheck(winNumber, bonusNumber))
        }
        val winCount = countWins(wins)
        val prize = sumPrize(wins)
        val rate = profitRate(prize)
        return Pair(winCount, rate)
    }

    private fun countWins(wins: ArrayList<WinCondition>): List<Int> {
        val winCount = mutableListOf(0, 0, 0, 0, 0, 0)
        wins.forEach { win ->
            when(win) {
                WinCondition.FIRST_PRIZE -> winCount[0]++
                WinCondition.SECOND_PRIZE -> winCount[1]++
                WinCondition.THIRD_PRIZE -> winCount[2]++
                WinCondition.FOURTH_PRIZE -> winCount[3]++
                WinCondition.FIFTH_PRIZE -> winCount[4]++
                WinCondition.NONE -> winCount[5]++
            }
        }
        return winCount.toList()
    }

    private fun sumPrize(wins: ArrayList<WinCondition>): Int {
        var prize = 0
        wins.forEach { win ->
            prize += win.prize()
        }
        return prize
    }

    private fun profitRate(prize: Int): Double {
        val spending = lottos.size * 1000
        var rate = (prize.toDouble() / spending.toDouble()) * 1000.0
        rate = rate.roundToInt().toDouble() / 10
        return rate
    }
}