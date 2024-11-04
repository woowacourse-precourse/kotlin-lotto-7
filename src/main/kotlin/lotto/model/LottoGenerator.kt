package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator(private val tickets: Int) {
    fun purchaseLotto(): List<List<Int>> {
        val lottoTickets: MutableList<MutableList<Int>> = mutableListOf()
        repeat(tickets) { lottoTickets.add(generateLotto()) }
        return lottoTickets
    }

    private fun generateLotto(): MutableList<Int> {
        return Randoms.pickUniqueNumbersInRange(LOWER_RANGE_NUMBER, UPPER_RANGE_NUMBER, TICKETS)
    }

    companion object {
        private const val LOWER_RANGE_NUMBER = 1
        private const val UPPER_RANGE_NUMBER = 45
        private const val TICKETS = 6
    }
}