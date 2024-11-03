package lotto.Util

object Validator {
    private const val ERROR_INVALID_NUMBER = "[ERROR] 유효한 숫자를 입력해 주세요."
    private const val ERROR_INVALID_AMOUNT = "[ERROR] 금액은 1000원 단위여야 합니다."
    private const val ERROR_INVALID_WINNING_NUMBERS = "[ERROR] 당첨 번호는 1~45 사이의 중복되지 않는 숫자 6개여야 합니다."
    private const val ERROR_INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 1~45 사이의 숫자이며, 당첨 번호와 중복되지 않아야 합니다."

    // 로또 구매 금액 유효성 검사
    fun validatePurchaseInput(input: String?): Int {
        // 입력값이 null이거나 숫자로 변환할 수 없는 경우 예외 처리
        val amount = input?.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER)

        // 금액이 1000으로 나누어떨어지지 않는 경우 예외 처리
        if (amount % 1000 != 0) {
            throw IllegalArgumentException(ERROR_INVALID_AMOUNT)
        }
        return amount
    }

    // 당첨 번호 유효성 검사
    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6 || numbers.any { it !in 1..45 } || numbers.distinct().size != 6) {
            throw IllegalArgumentException(ERROR_INVALID_WINNING_NUMBERS)
        }
    }

    // 보너스 번호 유효성 검사
    fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber !in 1..45 || bonusNumber in winningNumbers) {
            throw IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER)
        }
    }
}