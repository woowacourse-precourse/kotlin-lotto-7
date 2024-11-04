package lotto.controller

import lotto.validator.Validator
import lotto.view.GuideOutput
import lotto.view.Input

class LottoController {
    fun run() {
        val amount = retryOnFailure { amountInterface() }
    }

    private fun <T> retryOnFailure(inputFunction: () -> T): T {
        return runCatching { inputFunction() }
            .getOrElse {
                println(it.message)
                retryOnFailure(inputFunction)
            }
    }

    fun amountInterface(): String {
        GuideOutput.amount()
        return Input.amount().also {
            Validator.requireAmount(it)
        }
    }
}