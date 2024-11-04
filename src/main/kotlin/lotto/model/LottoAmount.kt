package lotto.model

import lotto.constants.ErrorMessages.ERROR_LOTTO_MINIMUM_AMOUNT
import lotto.constants.ErrorMessages.ERROR_LOTTO_THOUSAND_UNIT_AMOUNT
import lotto.constants.LottoNumbers.LOTTO_PRICE

class LottoAmount(val money: Int) {

    init {
        require(money > ZERO) { ERROR_LOTTO_MINIMUM_AMOUNT }
        require(money % LOTTO_PRICE == ZERO) { ERROR_LOTTO_THOUSAND_UNIT_AMOUNT }
    }

    companion object {
        private const val ZERO = 0
    }
}