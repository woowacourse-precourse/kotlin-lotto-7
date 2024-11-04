package lotto.controller

import lotto.model.Amount
import lotto.validator.Validator
import lotto.view.GuideOutput
import lotto.view.Input

class LottoController {
    fun run() {
        val amount = Validator.retryOnFailure { Amount(amountInterface()) }
    }

    fun amountInterface(): String {
        GuideOutput.amount()
        return Input.amount()
    }
}