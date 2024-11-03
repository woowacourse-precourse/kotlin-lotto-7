package lotto

class InputValidator {

    fun validatePurchaseAmount(input: String): Int {
        validatePurchaseAmountFormat(input)
        val amount = input.toInt()
        validatePositivePurchaseAmount(amount)
        validatePurchaseAmountUnit(amount)
        return amount
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        validateWinningNumbersCount(numbers)
        validateWinningNumberRange(numbers)
        validateNoDuplicateWinningNumbers(numbers)
        return numbers
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER_FORMAT)
        validateBonusNumberRange(bonus)
        validateNoDuplicateBonusNumber(bonus, winningNumbers)
        return bonus
    }

    private fun validatePurchaseAmountFormat(input: String) {
        require(input.matches(Regex("\\d+"))) { ERROR_INVALID_PURCHASE_AMOUNT_FORMAT }
    }

    private fun validatePositivePurchaseAmount(amount: Int) {
        require(amount > 0) { ERROR_INVALID_PURCHASE_AMOUNT_NONPOSITIVE }
    }

    private fun validatePurchaseAmountUnit(amount: Int) {
        require(amount % 1000 == 0) { ERROR_INVALID_PURCHASE_AMOUNT_UNIT }
    }

    private fun validateWinningNumbersCount(numbers: List<Int>) {
        require(numbers.size == 6) { ERROR_INVALID_WINNING_NUMBERS_COUNT }
    }

    private fun validateWinningNumberRange(numbers: List<Int>) {
        require(numbers.all { it in 1..45 }) { ERROR_INVALID_WINNING_NUMBER_RANGE }
    }

    private fun validateNoDuplicateWinningNumbers(numbers: List<Int>) {
        require(numbers.distinct().size == numbers.size) { ERROR_DUPLICATE_WINNING_NUMBERS }
    }

    private fun validateBonusNumberRange(bonus: Int) {
        require(bonus in 1..45) { ERROR_INVALID_WINNING_NUMBER_RANGE }
    }

    private fun validateNoDuplicateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
        require(bonus !in winningNumbers) { ERROR_DUPLICATE_BONUS_NUMBER }
    }

    companion object {
        const val ERROR_INVALID_PURCHASE_AMOUNT_FORMAT = "[ERROR] 구입 금액은 숫자로 입력해야 합니다."
        const val ERROR_INVALID_PURCHASE_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."
        const val ERROR_INVALID_PURCHASE_AMOUNT_NONPOSITIVE = "[ERROR] 구입 금액은 0보다 커야 합니다."
        const val ERROR_INVALID_WINNING_NUMBERS_COUNT = "[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다."
        const val ERROR_DUPLICATE_WINNING_NUMBERS = "[ERROR] 당첨 번호에는 중복된 숫자가 없어야 합니다."
        const val ERROR_INVALID_BONUS_NUMBER_FORMAT = "[ERROR] 보너스 번호는 숫자로 입력해야 합니다."
        const val ERROR_DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."
        const val ERROR_INVALID_WINNING_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}