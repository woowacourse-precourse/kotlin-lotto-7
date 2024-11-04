package lotto.validator

import lotto.utils.IntException

object Validator {
    fun requireAmount(amount: String) {
        require(amount.isNotBlank()) { IntException.BLANK }
        require(amount.toIntOrNull() != null) { IntException.NOT_INT }
        require(amount.toInt() >= 0) { IntException.NEGATIVE_INT }
        require((amount.toInt() % 1000 == 0)) { IntException.NOT_THOUSAND_UNIT }

    }

    fun <T> retryOnFailure(inputFunction: () -> T): T {
        while (true) {
            try {
                return inputFunction()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                retryOnFailure(inputFunction)
            }
        }
    }
}