package lotto.domain

import lotto.constants.ErrorConstant

class PurchaseAmount(private val money: Int) {
    init {
        require(money % 1000 == 0) { ErrorConstant.ERROR_PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000 }
        require(money >= 1000) { ErrorConstant.ERROR_PURCHASE_AMOUNT_NOT_ENOUGH }
    }
}