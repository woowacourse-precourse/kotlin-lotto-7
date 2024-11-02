package lotto.model

import lotto.utils.ErrorFormatter

class PurchaseMoney(moneyINput: String) {

    val money : Int

    init {
        money = validatePurchaseMoney(moneyINput)
    }

    private fun validatePurchaseMoney(input: String) : Int {
        val regex = Regex("^\\d*$")
        require(regex.matches(input)) {
            ErrorFormatter.getErrorMessage(INVALID_PURCHASE_MONEY)
        }


        val purchaseMoney = input.toInt()
        require(purchaseMoney >= MIN_PURCHASE_MONEY
                && purchaseMoney % LOTTO_UNIT_PRICE == 0) {
            ErrorFormatter.getErrorMessage(INVALID_PRICE_UNIT)
        }

        return purchaseMoney
    }

    companion object {
        private const val MIN_PURCHASE_MONEY = 1000
        private const val LOTTO_UNIT_PRICE = 1000
        private const val INVALID_PURCHASE_MONEY = "구입 금액은 숫자로 입력해야 합니다."
        private const val INVALID_PRICE_UNIT = "구입 금액은 1,000원 단위로만 가능합니다."
    }

}