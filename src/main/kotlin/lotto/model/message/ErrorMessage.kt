package lotto.model.message

enum class ErrorMessage(val message: String) {
    PURCHASE_PRICE_1000("구입 금액은 1000원 단위여야 합니다."),
    DEFAULT_ERROR("오류가 발생하였습니다."),
    EMPTY_PURCHASE_PRICE("숫자를 입력해주세요."),
    INPUT_WINNING_6_NUMBERS("당첨번호는 6개 입력해주셔야 됩니다."),
    INPUT_WINNING_ONLY_NUMBERS("당첨번호는 숫자로 입력해주셔야 합니다."),
    INPUT_WINNING_EMPTY("당첨번호에 빈문자열을 입력받았습니다.")
}