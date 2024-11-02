package lotto

enum class ErrorMessage(private val message: String) {
    INPUT_NOT_NUMBER("입력값은 정수여야 합니다."),
    INPUT_IS_NULL("값을 입력해주세요."),
    LOTTO_OUT_OF_BOUND("로또 번호는 1부터 45까지의 숫자여야 합니다."),
    LOTTO_NOT_SIX("로또 번호는 6개여야 합니다."),
    LOTTO_BONUS_NOT_ONE("보너스 번호는 1개여야 합니다."),
    BILLS_NOT_ENOUGH("구입 금액의 최소값은 1000입니다."),
    BILLS_NOT_DIVIDED("구입 금액은 1천 단위여야 합니다.");

    fun getMessage(): String = "[ERROR] ${this.message}"
}