package lotto.model

import lotto.validator.Validator

class Amount(private val amount: String) {
    init {
        Validator.requireAmount(amount)
    }

    fun generateToTry(): Int {
        return amount.toInt() / 1000
    }
}