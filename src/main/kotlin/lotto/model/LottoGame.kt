package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.controller.Ranking

class LottoGame {
    private var _winningNumbers: List<Int> = listOf()
    private val lottoTickets: MutableList<List<Int>> = mutableListOf()

    fun set(winningNumbers: List<Int>) {
        _winningNumbers = winningNumbers
    }

    fun validatePrice(price: String): Int? {
        return price.toIntOrNull()
    }

    fun buy(price: Int): Int {
        return price / LOTTO_TICKET_PRICE
    }

    fun generateLottoTickets(count: Int): List<List<Int>> {
        repeat(count) {
            val numbers = pickUniqueNumbersInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER, WINNING_BALL_COUNT)
            val lottoTicket = Lotto(numbers).sort()
            println(lottoTicket)
            lottoTickets.add(lottoTicket)
        }
        return lottoTickets
    }

    fun checkScore(lottoNumber: List<Int>): Int {
        var winningCount = 0
        lottoNumber.forEach {
            if (_winningNumbers.contains(it)) {
                winningCount ++
            }
        }
        return winningCount
    }

    fun isBonus(bonusNumber: Int): Boolean {
        return _winningNumbers.contains(bonusNumber)
    }

    fun getWinnings(bonusNumber: String): List<Int> {
        val winningGames = MutableList(5) { 0 }
        for (lotto in lottoTickets) {
            val win = checkScore(lotto)
            val bonus = isBonus(bonusNumber.toInt())
            when {
                win == 6 -> winningGames[Ranking.FIRST.getIndex()] += 1
                win == 5 && bonus -> winningGames[Ranking.SECOND.getIndex()] += 1
                win == 5 && !bonus -> winningGames[Ranking.THIRD.getIndex()] += 1
                win == 4 -> winningGames[Ranking.FOURTH.getIndex()] += 1
                win == 3 -> winningGames[Ranking.FIFTH.getIndex()] += 1
            }
        }
        return winningGames
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000

        const val MAX_BALL_NUMBER = 45
        const val MIN_BALL_NUMBER = 1
        const val WINNING_BALL_COUNT = 6
    }
}