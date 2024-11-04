package lotto.domain.validation

import lotto.domain.model.Lotto.Companion.LOTTO_PRICE
import lotto.domain.exception.ExceptionMessages

fun validateBudget(budget: Int) {
    require(budget > 0) { ExceptionMessages.BUDGET_NEEDS_TO_BE_BIGGER_THAN_ZERO }
    require(budget % LOTTO_PRICE == 0) { ExceptionMessages.BUDGET_NOT_DIVISIBLE_BY_LOTTO_PRICE }
}
