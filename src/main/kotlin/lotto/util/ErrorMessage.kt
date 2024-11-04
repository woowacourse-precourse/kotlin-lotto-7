package lotto.util

enum class ErrorMessage(private val message: String) {
    INPUT_NULL("입력값이 존재하지 않습니다."),
    INPUT_DIGIT("입력값은 숫자여야 합니다."),
    INPUT_NATURAL("입력값은 자연수여야 합니다."),
    AMOUNT_UNIT("구매 금액은 1000원 단위로 입력되어야 합니다."),
    AMOUNT_VALUE("구매 금액은 최소 1000원 이상이어야 합니다."),
    LOTTO_RANGE("로또 번호의 범위는 1~45 사이여야 합니다."),
    LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE("당첨 번호는 중복될 수 없습니다."),
    BONUS_RANGE("보너스 번호의 범위는 1~45 사이여야 합니다."),
    BONUS_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    fun getMessage(): String = "[ERROR] $message"
}
