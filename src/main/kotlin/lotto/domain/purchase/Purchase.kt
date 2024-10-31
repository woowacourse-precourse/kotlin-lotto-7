package lotto.domain.purchase

import lotto.validator.PurchaseAmountValidator

class Purchase private constructor(val amount: Int) {

    companion object {
        fun valueOf(input: String): Purchase {
            PurchaseAmountValidator.validate(input)
            return Purchase(input.toInt())
        }
    }

}