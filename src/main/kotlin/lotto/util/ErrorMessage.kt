package lotto.util

enum class ErrorMessage(private val message: String) {
    PURCHASE_PRICE_MORE_THAN_THOUSAND("구입 금액은 최소 1,000원 부터 입니다."),
    INVALID_PURCHASE_PRICE("구입 금액은 1,000원 단위 입니다."),
    PURCHASE_PRICE_MUST_BE_NUMBER("구입 금액은 숫자만 입력 가능 합니다."),
    PURCHASE_PRICE_EMPTY("구입 금액은 비어있을 수 없습니다."),
    LOTTO_NUMBERS_MUST_SIX_LETTERS("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_MUST_UNIQUE("로또 번호는 중복 되면 안됩니다."),
    LOTTO_NUMBER_EXCEEDS_MAX("로또 번호는 45보다 클 수 없습니다."),
    INPUT_VALUE_MUST_NUMBER("입력 값은 숫자 여야 합니다.");

    fun getMessage(): String = "[ERROR] $message"
}