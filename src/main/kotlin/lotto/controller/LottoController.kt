package lotto.controller

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.Lotto
import lotto.view.Input

class LottoController(val input: Input) {
    private fun getLottoTicketCount(): Int {
        return input.getPurchaseAmount() / 1000
    }

    private fun createRandomLotto(): Lotto {
        return Lotto(pickUniqueNumbersInRange(1, 45, 6).sorted())
    }
}