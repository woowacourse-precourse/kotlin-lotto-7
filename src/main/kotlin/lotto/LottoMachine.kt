package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateLottoTickets(lottoTicketCount: Int): List<Lotto> {
        return List(lottoTicketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        }
    }
}