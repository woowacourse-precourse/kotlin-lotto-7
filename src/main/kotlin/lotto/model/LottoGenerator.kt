package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun purchaseLotto(tickets: Int): List<List<Int>> {
        val lottoTickets: MutableList<MutableList<Int>> = mutableListOf()
        for (ticket in 1..tickets) {
            lottoTickets.add(generateLotto())
        }
        return lottoTickets
    }

    private fun generateLotto(): MutableList<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}