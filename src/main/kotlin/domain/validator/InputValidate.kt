package domain.validator

interface InputValidate {
    fun payValidation(value: String): Pair<String, Int>
    fun winningNumberValidation(value: String): List<Int>
    fun bonusNumberValidation(value: String): Int
}