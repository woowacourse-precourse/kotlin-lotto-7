package lotto.model

import lotto.utils.Constants.LIMIT_OF_PURCHASE
import lotto.utils.Constants.LOTTO_PRICE
import lotto.utils.Constants.MAX_NUMBER
import lotto.utils.Constants.MIN_NUMBER
import lotto.utils.Constants.ZERO
import lotto.utils.ErrorConstants

object InputValidator {

    fun validatePurchaseAmount(purchaseAmount: Int?) {
        require(purchaseAmount != null) { ErrorConstants.NOT_NUMBER }
        require(purchaseAmount > ZERO) { ErrorConstants.NEGATIVE_NUMBER }
        require(purchaseAmount <= LIMIT_OF_PURCHASE) { ErrorConstants.LIMIT_OF_PURCHASE }
        require(purchaseAmount % LOTTO_PRICE == ZERO) { ErrorConstants.NOT_DIVIDED }
    }

    fun validateBonusNumber(bonusNumber: Int?, winningNumbers: List<Int>) {
        when {
            bonusNumber == null -> throw NumberFormatException(ErrorConstants.LOTTO_NUMBER_RANGE)
            bonusNumber in winningNumbers -> throw IllegalArgumentException(ErrorConstants.DUPLICATE_BONUS_NUMBER)
            bonusNumber !in MIN_NUMBER..MAX_NUMBER -> throw IllegalArgumentException(ErrorConstants.LOTTO_NUMBER_RANGE)
        }
    }
}
