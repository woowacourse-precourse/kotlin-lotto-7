package lotto

class InputValidator {

    fun validatePurchaseAmount(input: String): String {
        require(input.matches(Regex("\\d+"))) { ERROR_INVALID_PURCHASE_AMOUNT_FORMAT }
        val amount = input.toInt()
        require(amount % 1000 == 0) { ERROR_INVALID_PURCHASE_AMOUNT_UNIT }
        return input
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").mapNotNull {
            it.trim().toIntOrNull()
        }
        require(numbers.size == 6) { ERROR_INVALID_WINNING_NUMBERS_COUNT }
        require(numbers.all { it in 1..45 }) { ERROR_INVALID_WINNING_NUMBER_RANGE }
        return numbers
    }

    fun validateBonusNumber(input: String): Int {
        val bonus = input.toIntOrNull()
        require(bonus != null) { ERROR_INVALID_BONUS_NUMBER_FORMAT }
        require(bonus in 1..45) { ERROR_INVALID_WINNING_NUMBER_RANGE }
        return bonus
    }

    companion object {
        const val ERROR_INVALID_PURCHASE_AMOUNT_FORMAT = "[ERROR] 유효하지 않은 구입 금액입니다. 숫자를 입력해 주세요."
        const val ERROR_INVALID_PURCHASE_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."
        const val ERROR_INVALID_WINNING_NUMBERS_COUNT = "[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다."
        const val ERROR_INVALID_WINNING_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        const val ERROR_INVALID_BONUS_NUMBER_FORMAT = "[ERROR] 유효하지 않은 보너스 번호입니다. 숫자를 입력해 주세요."
    }
}