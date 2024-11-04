package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.util.ErrorMessage
import lotto.util.LottoConstants

class LottoGenerator(private val purchasePrice: Int) {
    init {
        require(purchasePrice >= 1000) { ErrorMessage.PURCHASE_PRICE_MORE_THAN_THOUSAND.getMessage() }
        require(purchasePrice % 1000 == 0) { ErrorMessage.INVALID_PURCHASE_PRICE.getMessage() }
    }

    fun generate(): List<Lotto> {
        val lottoCount = getLottoCount()
        val lottoList = List(lottoCount) {
            generateOneLotto()
        }
        return lottoList
    }

    private fun getLottoCount(): Int = purchasePrice / LottoConstants.PRICE

    private fun generateOneLotto(): Lotto {
        val randomUniqueNumbers = pickUniqueNumbersInRange(
            LottoConstants.MIN_NUMBER,
            LottoConstants.MAX_NUMBER,
            PICK_COUNT
        )
        return Lotto(randomUniqueNumbers)
    }

    companion object {
        private const val PICK_COUNT = 6
    }
}