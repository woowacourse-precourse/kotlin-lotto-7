package lotto.domain.validator

import lotto.domain.enums.Process

interface InputValidate {
    fun payValidation(value: String): Pair<String, Int>
    fun winningNumberValidation(value: String): List<Int>
    fun bonusNumberValidation(value: String): Int
    fun commonValidation(value: String, process: Process)
}