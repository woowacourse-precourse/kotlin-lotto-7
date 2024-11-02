package lotto.utils

enum class ErrorMessage(private val message: String) {
//    "금액은 1,000원 단위로 입력해야 합니다.
// "금액은 숫자여야합니다.

    INVALID_AMOUNT("금액은 1,000원 단위로 입력해야 합니다."),
    NOT_NUMBER("금액은 숫자여야합니다."),
    INVALID_WINNING_NUMBERS("당첨 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBER("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    UNKNOWN_ERROR("알 수 없는 오류가 발생했습니다.");

    companion object {
        private const val ERROR_TAG: String = "[ERROR]"
        private const val ERROR_SEPARATOR: String = " "
    }

    fun getMessage(): String {
        return ERROR_TAG + ERROR_SEPARATOR + message
    }


}