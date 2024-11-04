package lotto.controller

import lotto.model.Amount
import lotto.model.CreateLotto
import lotto.validator.Validator
import lotto.view.GuideOutput
import lotto.view.Input
import lotto.view.UserFeedback

class LottoController {
    private val numbers: MutableList<MutableList<Int>> = mutableListOf()
    fun run() {
        val amount = Validator.retryOnFailure { Amount(amountInterface()) }
        val tryCount = amount.generateToTry()
        repeat(tryCount) {
            numbers.add(CreateLotto().random())
        }
        UserFeedback.randomLotoo(tryCount, numbers)
    }

    fun amountInterface(): String {
        GuideOutput.amount()
        return Input.amount()
    }
}