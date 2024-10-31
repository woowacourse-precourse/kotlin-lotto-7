package lotto.domain.purchase

import lotto.validator.PurchaseAmountValidator

class Purchase private constructor(private val amount: Int) {

    companion object {
        fun valueOf(input: String): Purchase {
            PurchaseAmountValidator.validate(input)
            return Purchase(input.toInt())
        }
    }

    fun getAmount(): Int {
        return amount
    }

}