package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun purchaseLotto(tickets: Int): List<List<Int>> {
        val lottoTickets: MutableList<MutableList<Int>> = mutableListOf()
        for (ticket in INIT_TICKET..tickets) {
            lottoTickets.add(generateLotto())
        }
        return lottoTickets
    }

    private fun generateLotto(): MutableList<Int> {
        return Randoms.pickUniqueNumbersInRange(LOWER_RANGE_LOTTO_NUMBER, UPPER_RANGE_LOTTO_NUMBER, TICKETS)
    }

    companion object {
        private const val INIT_TICKET = 1
        private const val LOWER_RANGE_LOTTO_NUMBER = 1
        private const val UPPER_RANGE_LOTTO_NUMBER = 45
        private const val TICKETS = 6
    }
}