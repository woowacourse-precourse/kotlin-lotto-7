package lotto.domain

import lotto.constants.ErrorConstants.ERROR_LOTTOS_SIZE
import lotto.constants.ErrorConstants.ERROR_NUMBER_ONLY_NUMERIC
import lotto.constants.ErrorConstants.ERROR_PRICE_NOT_MULTIPLE_OF_1000
import lotto.constants.ErrorConstants.ERROR_PURCHASE_PRICE_MINIMUM
import lotto.constants.LottoConstants.LOTTO_PRICE

class LottoAmount(val purchasePrice: String) {
    val purchaseCount: Int
    val lottos: List<Lotto>

    init {
        val price = purchasePrice.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_NUMBER_ONLY_NUMERIC)
        purchaseCount = price / LOTTO_PRICE

        lottos = List(purchaseCount) { Lotto(getLottoNumbers()) }

        require(price % LOTTO_PRICE == 0) { ERROR_PRICE_NOT_MULTIPLE_OF_1000 }
        require(price >= LOTTO_PRICE) { ERROR_PURCHASE_PRICE_MINIMUM }
        require(lottos.size == purchaseCount) { ERROR_LOTTOS_SIZE }
    }
}
