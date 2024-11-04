package lotto.exception

enum class ExceptionCode(private val message: String) {
    INVALID_PURCHASE_AMOUNT_UNIT("로또 구매 단위는 1000원입니다."),
    INVALID_NUMERIC("숫자가 아닌 문자가 존재합니다."),
    INVALID_LOTTO_NUMBER_COUNT("쉼표(,)를 구분자로 총 6개의 숫자를 입력해주세요."),
    OUT_OF_BOUND_PURCHASE_AMOUNT("로또 구매 한도는 100,000원입니다."),
    OUT_OF_BOUND_LOTTO_NUMBER("로또 번호는 1부터 45까지의 정수만 선택할 수 있습니다."),
    DUPLICATE_LOTTO_NUMBER("중복된 로또 번호가 존재합니다.");

    fun getMessage(): String {
        return "[ERROR] ${this.message}"
    }
}