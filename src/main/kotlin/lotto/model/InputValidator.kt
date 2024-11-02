package lotto.model

import jdk.jfr.DataAmount
import lotto.utils.Constants
import lotto.utils.Constants.LIMIT_OF_PURCHASE
import lotto.utils.Constants.LOTTO_PRICE
import lotto.utils.Constants.ZERO
import lotto.utils.ErrorConstants

object InputValidator {

    fun validatePurchaseAmount(purchaseAmount: Int?) {
        require(purchaseAmount != null) { ErrorConstants.NOT_NUMBER }
        require(purchaseAmount > ZERO) { ErrorConstants.NEGATIVE_NUMBER }
        require(purchaseAmount <= LIMIT_OF_PURCHASE) { ErrorConstants.LIMIT_OF_PURCHASE }
        require(purchaseAmount % LOTTO_PRICE == ZERO) { ErrorConstants.NOT_DIVIDED }
    }

    fun validateBonusNumber() {

    }

}
