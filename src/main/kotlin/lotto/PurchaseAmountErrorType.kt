package lotto

enum class PurchaseAmountErrorType(
    private var _errorMessage: String
) {
    EMPTY_INPUT("로또 구매 금액은 빈 문자를 입력하면 안됩니다."),
    NOT_DECIMAL("로또 구매 금액은 소수를 입력하면 안됩니다."),
    NOT_INTEGER("로또 구매 금액은 양의 정수 외 다른것을 입력하면 안됩니다."),
    ZERO_AMOUNT("로또 구매 금액은 0를 입력하면 안됩니다."),
    LESS_THAN_1000("로또 구매 금액은 1000원이상 입력해야합니다."),
    NOT_UNITS_OF_1000("로또 구매 금액은 1000원단위로 입력해야합니다.");

    val errorMessage: String
        get() = ERROR_MESSAGE + _errorMessage

    companion object {
        private const val ERROR_MESSAGE = "[Error] "
    }
}