package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.util.ErrorMessage
import lotto.util.LottoConstants

class LottoMachine(private val purchasePrice: Int) {
    init {
        require(purchasePrice >= 1000) { ErrorMessage.PURCHASE_PRICE_MORE_THAN_THOUSAND.getMessage() }
        require(purchasePrice % 1000 == 0) { ErrorMessage.INVALID_PURCHASE_PRICE.getMessage() }
    }

    private fun getLottoCount(): Int = purchasePrice / LottoConstants.PRICE

    private fun generateOneLotto(): Lotto {
        val randomUniqueNumbers = pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_COUNT)
        return Lotto(randomUniqueNumbers)
    }

    companion object {
        private const val START_NUMBER = 0
        private const val END_NUMBER = 45
        private const val PICK_COUNT = 6
    }
}