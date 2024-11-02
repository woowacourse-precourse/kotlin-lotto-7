package lotto.util.validator.bonusnumber

enum class BonusNumberErrorType(
    private val _errorMessage: String
){
    EMPTY_INPUT("보너스 번호는 빈 문자를 입력하면 안됩니다."),
    NOT_DECIMAL("보너스 번호는 소수를 입력하면 안됩니다."),
    NOT_INTEGER("보너스 번호는 정수 외 다른것을 입력하면 안됩니다."),
    BONUS_NUMBER_RANGE("보너스 번호는 1부터 45까지 가능합니다."),
    NO_DUPLICATE_LUCKY_NUMBERS("당첨 번호와 중복된 숫자가 있습니다.");

    val errorMessage: String
        get() = ERROR_MESSAGE + _errorMessage

    companion object {
        private const val ERROR_MESSAGE = "[Error] "
    }
}