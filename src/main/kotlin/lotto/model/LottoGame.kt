package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

class LottoGame {
    private var numbers: List<Int> = listOf()

    fun set(lottoNumbers: List<Int>) {
        numbers = lottoNumbers
    }

    fun validatePrice(price: String): String? {
        if (price.toIntOrNull() == null) {
            return "[ERROR] 구매 가격은 숫자여야 합니다."
        }
        return null
    }

    fun buy(price: String): Int {
        return price.toInt() / LOTTO_TICKET_PRICE
    }

    fun generateLottoTickets(count: Int): List<List<Int>> {
        val lottoTickets: MutableList<List<Int>> = mutableListOf()
        repeat(count) {
            val numbers = pickUniqueNumbersInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER, WINNING_BALL_COUNT)
            val lottoTicket = Lotto(numbers).sort()
            println(lottoTicket)
            lottoTickets.add(lottoTicket)
        }
        return lottoTickets
    }

    fun check(winningNumbers: List<Int>): Int {
        var winningCount = 0
        winningNumbers.forEach {
            if (numbers.contains(it)) {
                winningCount ++
            }
        }
        return winningCount
    }

    fun isBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000

        const val MAX_BALL_NUMBER = 45
        const val MIN_BALL_NUMBER = 1
        const val WINNING_BALL_COUNT = 6
    }
}