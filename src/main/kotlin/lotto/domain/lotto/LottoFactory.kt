package lotto.domain.lotto

import lotto.domain.numbergenerator.NumberGenerator
import lotto.domain.purchase.Purchase
import lotto.exception.ExceptionCode
import lotto.exception.LottoException

object LottoFactory {
    fun buyLottoTicket(purchase: Purchase, numberGenerator: NumberGenerator): LottoTicket {
        return LottoTicket.publish(purchase.getNumberOfLotto(), numberGenerator)
    }

    fun getWinningLotto(winningLottoInput: List<Int>): Lotto {
        return Lotto(winningLottoInput)
    }

    fun getBonusNumber(input: Int, winningNumbers: Lotto): BonusNumber {
        if (winningNumbers.isDuplicateNumber(input)) {
            throw LottoException(ExceptionCode.DUPLICATE_LOTTO_NUMBER)
        }
        return BonusNumber(input)
    }
}