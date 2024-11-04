package lotto

enum class ErrorMessage(private val message: String) {
    INPUT_AMOUNT_ERROR("구매할 수 있는 금액은 1000으로 나누어 떨어져야 합니다."),
    INPUT_AMOUNT_FORMAT_ERROR("구매할 수 있는 금액은 1000으로 나누어 떨어지는 숫자만 입력해야 합니다."),
    INPUT_WINNING_NUMBER_COUNT_ERROR("당첨 번호는 6개의 숫자여야 합니다."),
    INPUT_WINNING_NUMBER_OUT_OF_RANGE_ERROR("당첨 번호는 1부터 45사이에 숫자여야 합니다."),
    INPUT_WINNING_NUMBER_NO_DUPLICATE("당첨 번호는 중복되지 않은 숫자여야 합니다."),
    INPUT_WINNING_NUMBER_INVALID_INPUT_ERROR("당첨 번호는 1부터 45사이에 숫자를 ,로 구분하여 6개 입력해야 합니다."),
    INPUT_BONUS_NUMBER_INVALID_INPUT_ERROR("보너스 번호는 1부터 45사이에 숫자만 입력해야 합니다."),
    INPUT_BONUS_NUMBER_OUT_OF_RANGE_ERROR("보너스 번호는 1부터 45사이에 숫자여야 합니다."),
    INPUT_BONUS_NUMBER_NOT_CONTAIN_WINNING_NUMBERS("보너스 번호는 당첨번호에 있지 않은 숫자여야 합니다."),
    LOTTO_NUMBER_NO_DUPLICATE("로또 번호는 중복되지 않은 숫자여야 합니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다.");

    fun getMessage(): String = "[ERROR] $message"
}