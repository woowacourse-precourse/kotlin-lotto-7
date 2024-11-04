package lotto.controller

import lotto.model.Amount
import lotto.model.CreateLotto
import lotto.model.Lotto
import lotto.validator.Validator
import lotto.view.GuideOutput
import lotto.view.Input
import lotto.view.UserFeedback

class LottoController {
    private val numbers: MutableList<MutableList<Int>> = mutableListOf()
    fun run() {
        val amount = Validator.retryOnFailure { Amount(amountInterface()) } //TODO: 함수로 만들어 재사용하기
        val tryCount = amount.generateToTry()
        repeat(tryCount) {
            numbers.add(CreateLotto().random())
        }
        UserFeedback.randomLotoo(tryCount, numbers)

        val winNumber = Validator.retryOnFailure { Lotto(numberInterface()) }

    }

    fun amountInterface(): String {
        GuideOutput.amount()
        return Input.amount()
    }

    fun numberInterface(): List<Int> {
        GuideOutput.winNumber()
        val numbers = Input.winNumber()
        return numbers.split(",").map { it.trim().toInt() }.sorted()
    }
}