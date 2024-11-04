package lotto.validator

import lotto.utils.intException

object Validator {
    fun requireAmount(amount: String) {
        require(amount.isNotBlank()) { intException.BLANK }
        require(amount.toIntOrNull() != null) { intException.NOT_INT }
        require(amount.toInt() >= 0) { intException.NEGATIVE_INT }
        require((amount.toInt() % 1000 == 0)) { intException.NOT_THOUSAND_UNIT }

    }


}