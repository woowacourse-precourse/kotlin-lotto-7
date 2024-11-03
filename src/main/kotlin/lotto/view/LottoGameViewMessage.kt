package lotto.view

enum class LottoGameViewMessage(private val text: String) {
    PROMPT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ERROR_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    ERROR_EMPTY_INPUT("입력이 비어있습니다."),
    ERROR_INVALID_CHARACTERS("잘못된 문자가 포함되어 있습니다."),
    PRINT_PURCHASE_AMOUNT("%d개를 구매했습니다.");

    fun getMessage(): String {
        return text
    }

    fun getErrorMessage(): String {
        return "[ERROR] $text"
    }
}
