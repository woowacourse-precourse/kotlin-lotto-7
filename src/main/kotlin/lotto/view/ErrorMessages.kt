package lotto.view

enum class ErrorMessage(private val message: String) {
    INVALID_PURCHASE_AMOUNT("구입금액은 숫자로 입력하세요."),
    PURCHASE_AMOUNT_ZERO("구입 금액은 0보다 커야 합니다."),
    INVALID_PURCHASE_MONEY("구입 금액은 1,000원 단위여야 합니다."),

    INVALID_NUMBERS_COUNT("당첨 번호는 6개의 숫자를 입력해야 합니다."),
    INVALID_NUMBER_RANGE("모든 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBERS("당첨 번호는 중복 없이 입력해야 합니다."),

    INVALID_BONUS_NUMBER("올바른 숫자를 입력하세요."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    val errorMessage: String
        get() = ERROR_PREFIX + message

    companion object {
        private const val ERROR_PREFIX = "[ERROR] "
    }

}