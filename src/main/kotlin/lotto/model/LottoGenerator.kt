package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun generateLottoTickets(ticketCount: Int): List<List<Int>> {
        return List(ticketCount) {
            Randoms.pickUniqueNumbersInRange(1, 45, 6)
        }
    }
}