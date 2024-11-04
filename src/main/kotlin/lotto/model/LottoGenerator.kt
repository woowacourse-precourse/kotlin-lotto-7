package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.util.ErrorMessage
import lotto.util.LottoConstants
import lotto.util.validator.LottoGeneratorValidator

class LottoGenerator(private val purchasePrice: Int) {
    init {
        require(LottoGeneratorValidator.isMoreThanOneThousand(purchasePrice)) {
            ErrorMessage.PURCHASE_PRICE_MORE_THAN_THOUSAND.getMessage()
        }
        require(LottoGeneratorValidator.isThousandUnit(purchasePrice)) {
            ErrorMessage.INVALID_PURCHASE_PRICE.getMessage()
        }
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