package lotto.util

enum class ErrorMessages(val message: String) {
    ERROR_SIZE_NUMBERS("[ERROR] 로또 번호는 6개여야 합니다."),
    ERROR_RANGE_NUMBER("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."),
    ERROR_SAME_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    ERROR_PAYMENT_UNIT("[ERROR] 구매 금액은 1,000원 단위여야 합니다."),
    ERROR_POSITIVE_DIGIT("[ERROR] 구매 금액은 양수여야 합니다."),
    ERROR_MAX_PAYMENT("[ERROR] 구매 금액은 2,000,000,000 이하여야 합니다."),
    ERROR_ONLY_LONG_DIGIT("[ERROR] 구매 금액은 int 범위 내의 숫자여야 합니다."),
    ERROR_ONLY_DIGIT("[ERROR] 숫자만 입력 가능합니다.")
}