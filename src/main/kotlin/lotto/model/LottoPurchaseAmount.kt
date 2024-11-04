package lotto.model

import lotto.util.validateInt
import lotto.util.validatePositive
import lotto.util.validateDivisibleBy

class LottoPurchaseAmount private constructor(val money: Int) {
    companion object {
        fun from(inputLottoPurchaseAmount: String): LottoPurchaseAmount {
            return LottoPurchaseAmount(
                inputLottoPurchaseAmount
                    .validateInt()
                    .validatePositive()
                    .validateDivisibleBy(LottoStore.LOTTO_TICKET_PRICE)
            )
        }
    }
}