package lotto.domain.validator

import lotto.domain.enums.Process

interface InputValidate {
    fun payValidation(value: String)
    fun winningNumberValidation(value: String): List<Int>
    fun bonusNumberValidation(value: String, winningNumber: List<Int>): Int
    fun commonValidation(value: String, process: Process)
}