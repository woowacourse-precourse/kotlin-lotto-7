package lotto

object Validator {
    private const val ERROR_INVALID_NUMBER = "[ERROR] 유효한 숫자를 입력해 주세요."
    private const val ERROR_INVALID_AMOUNT = "[ERROR] 금액은 1000원 단위여야 합니다."

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
}