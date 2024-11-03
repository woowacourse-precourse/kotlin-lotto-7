package lotto.util.validator.purchaseamount

enum class PurchaseAmountErrorType(
    private val _errorMessage: String
) {
    EMPTY_INPUT("로또 구매 금액은 빈 문자를 입력하면 안 됩니다."),
    NOT_DECIMAL("로또 구매 금액은 소수를 입력하면 안 됩니다."),
    NOT_INTEGER("로또 구매 금액은 숫자만 입력해 주세요."),
    ZERO_AMOUNT("로또 구매 금액은 0을 입력하면 안 됩니다."),
    LESS_THAN_1000("로또 구매 금액은 1,000원 이상 입력해야 합니다."),
    NOT_UNITS_OF_1000("로또 구매 금액은 1,000원 단위로 입력해야 합니다.");

    val errorMessage: String
        get() = ERROR_MESSAGE + _errorMessage

    companion object {
        private const val ERROR_MESSAGE = "[ERROR] "
    }
}