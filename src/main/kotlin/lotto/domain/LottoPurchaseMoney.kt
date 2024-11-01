package lotto.domain

import lotto.constant.ExceptionMessage.ERROR_DIVISION
import lotto.constant.LottoRule

class LottoPurchaseMoney(purchasePrice: Int) : Money(purchasePrice) {
    init {
        require(amount % LottoRule.PRICE == 0) { ERROR_DIVISION }
    }
}