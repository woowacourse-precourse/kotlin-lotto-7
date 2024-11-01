package lotto.domain

import lotto.constant.ExceptionMessage.ERROR_DIVISION

class LottoPurchaseMoney(purchasePrice: Int) : Money(purchasePrice) {
    init {
        require(amount % Lotto.PRICE == 0) { ERROR_DIVISION }
    }
}