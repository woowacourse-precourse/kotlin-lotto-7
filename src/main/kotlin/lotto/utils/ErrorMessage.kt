package lotto.utils

enum class ErrorMessage(private val message: String) {
//    "금액은 1,000원 단위로 입력해야 합니다.
// "금액은 숫자여야합니다.

    INVALID_AMOUNT("금액은 ${String.format("%,d", Constants.LOTTO_PRICE)}원 단위로 입력해야 합니다."),
    NOT_NUMBER("금액은 숫자여야 합니다."),
    INVALID_LOTTO_NUMBERS("로또 번호는 ${Constants.LOTTO_SIZE}개여야 합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 ${Constants.RANDOM_MIN}부터 ${Constants.RANDOM_MAX} 사이의 숫자여야 합니다."),
    INVALID_DUPLICATE_NUMBER("로또 번호는 중복되어서는 안됩니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 ${Constants.RANDOM_MIN}부터 ${Constants.RANDOM_MAX} 사이의 숫자여야 합니다."),

    UNKNOWN_ERROR("알 수 없는 오류가 발생했습니다.");

    companion object {
        private const val ERROR_TAG: String = "[ERROR]"
        private const val ERROR_SEPARATOR: String = " "
    }

    fun getMessage(): String {
        return ERROR_TAG + ERROR_SEPARATOR + message
    }


}