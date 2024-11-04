package lotto

import lotto.Validation.validateInt
import lotto.Validation.validatePositive
import lotto.Validation.validateDivisibleBy

class LottoPurchaseAmount private constructor(val money: Int) {
    companion object {
        fun from(inputLottoPurchaseAmount: String): LottoPurchaseAmount {
            return LottoPurchaseAmount(
                inputLottoPurchaseAmount
                    .validateInt()
                    .validatePositive()
                    .validateDivisibleBy()
            )
        }
    }
}