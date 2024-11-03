package lotto.domain.lotto

import lotto.domain.numbergenerator.NumberGenerator
import lotto.domain.purchase.Purchase

object LottoFactory {
    fun buyLottoTicket(purchase: Purchase, numberGenerator: NumberGenerator): LottoTicket {
        return LottoTicket.publish(purchase.getNumberOfLotto(), numberGenerator)
    }

    fun getWinningLotto(winningLottoInput: List<Int>): Lotto {
        return Lotto(winningLottoInput)
    }
}