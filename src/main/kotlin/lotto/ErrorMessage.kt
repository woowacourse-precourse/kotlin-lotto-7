package lotto

enum class ErrorMessage(private val message: String) {
    INPUT_AMOUNT_ERROR("구매할 수 있는 금액은 1000으로 나누어 떨어져야 합니다.");

    fun getMessage(): String = "[ERROR] $message"
}