package lotto.exception

enum class ExceptionCode(private val message: String) {
    INVALID_PURCHASE_AMOUNT_UNIT("로또 구입 금액은 1,000원 단위로 입력 가능합니다."),
    INVALID_NUMERIC("숫자가 아닌 문자가 존재합니다."),
    INVALID_LOTTO_NUMBER_COUNT("(,)쉼표를 구분자로 총 6개의 숫자를 입력해야 합니다. (예시. 1,3,5,10,27,45)"),
    OUT_OF_BOUND_PURCHASE_AMOUNT("로또 구입 금액은 1,000원 ~ 100,000원 범위내에서 구입할 수 있습니다."),
    OUT_OF_BOUND_LOTTO_NUMBER("로또 번호는 1 ~ 45 범위 내에서 선택할 수 있습니다."),
    DUPLICATE_LOTTO_NUMBER("중복된 로또 번호가 존재합니다."),
    ;

    fun getMessage(): String {
        return "[ERROR] ${this.message}"
    }
}