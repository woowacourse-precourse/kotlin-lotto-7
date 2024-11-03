package lotto.view

enum class LottoGameViewMessage(private val text: String) {
    PROMPT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ERROR_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    ERROR_EMPTY_INPUT("입력이 비어있습니다."),
    ERROR_INVALID_CHARACTERS("잘못된 문자가 포함되어 있습니다."),
    PRINT_PURCHASE_AMOUNT("%d개를 구매했습니다."),
    PROMPT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ERROR_WINNING_NUMBERS_SIZE("당첨 번호는 6개여야 합니다."),
    ERROR_WINNING_NUMBERS_RANGE("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_DUPLICATED_WINNING_NUMBERS("당첨 번호는 중복될 수 없습니다."),
    ERROR_TRAILING_COMMA("입력의 마지막에 쉼표나 공백이 올 수 없습니다."),
    PROMPT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ERROR_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_DUPLICATED_LOTTO_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    fun getMessage(): String {
        return text
    }

    fun getErrorMessage(): String {
        return "[ERROR] $text"
    }
}
