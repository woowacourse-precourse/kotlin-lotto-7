package lotto.model

import lotto.validator.Validator

class Amount(private val amount: String) {
    init {
        Validator.requireAmount(amount)
    }

    fun generateToTry(amount: Int) {
        val tryCount = amount % 1000
    }
}