package lotto.model

import lotto.model.Lotto.Companion.LOTTO_PRICE

class LottoAmount(val money: Int) {

    init {
        require(money > ZERO) { ERROR_LOTTO_MINIMUM_AMOUNT }
        require(money % LOTTO_PRICE == ZERO) { ERROR_LOTTO_THOUSAND_UNIT_AMOUNT }
    }

    companion object {
        private const val ZERO = 0

        private const val ERROR_LOTTO_MINIMUM_AMOUNT = "[ERROR] 로또 구매 금액은 0원 이상이어야 합니다."
        private const val ERROR_LOTTO_THOUSAND_UNIT_AMOUNT = "[ERROR] 로또 구매 금액은 천 원 단위로 입력 가능합니다."
    }
}