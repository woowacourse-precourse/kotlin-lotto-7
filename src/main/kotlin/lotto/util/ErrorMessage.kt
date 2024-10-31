package lotto.util

enum class ErrorMessage(private val message: String) {
    PURCHASE_PRICE_MORE_THAN_THOUSAND("구입 금액은 최소 1,000원 부터 입니다."),
    INVALID_PURCHASE_PRICE("구입 금액은 1,000원 단위 입니다."),
    PURCHASE_PRICE_MUST_BE_NUMBER("구입 금액은 숫자만 입력 가능 합니다."),
    PURCHASE_PRICE_EMPTY("구입 금액은 비어있을 수 없습니다.");

    fun getMessage(): String = "[ERROR] $message"
}