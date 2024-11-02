package lotto.util.validator.luckynumbers

enum class LuckyNumbersErrorType (
    private val _errorMessage: String
) {
    EMPTY_INPUT("당첨 번호는 빈 문자를 입력하면 안됩니다."),
    NOT_DECIMAL("당첨 번호는 소수를 입력하면 안됩니다."),
    NOT_INTEGER("당첨 번호는 정수 외 다른것을 입력하면 안됩니다."),
    LUCKY_NUMBERS_RANGE("당첨 번호는 1부터 45까지 가능합니다."),
    NO_DUPLICATE_LUCKY_NUMBERS("당첨 번호에 중복된 숫자가 있습니다."),
    LUCKY_NUMBERS_6("당첨 번호는 6개여야 합니다."),
    N0_COMMA("쉼표(,)가 입력되 지 않았습니다");

    val errorMessage: String
        get() = ERROR_MESSAGE + _errorMessage

    companion object {
        private const val ERROR_MESSAGE = "[Error] "
    }
}