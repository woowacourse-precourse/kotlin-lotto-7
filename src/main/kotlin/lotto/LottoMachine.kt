package lotto

import lotto.util.ErrorMessage

class LottoMachine(private val purchasePrice: Int) {
    init {
        require(purchasePrice >= 1000) { ErrorMessage.PURCHASE_PRICE_MORE_THAN_THOUSAND.getMessage() }
        require(purchasePrice % 1000 == 0) { ErrorMessage.INVALID_PURCHASE_PRICE.getMessage() }
    }


}