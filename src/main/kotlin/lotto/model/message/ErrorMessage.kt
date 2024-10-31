package lotto.model.message

enum class ErrorMessage(val message: String) {
    PURCHASE_PRICE_1000("구입 금액은 1000원 단위여야 합니다."),
    DEFAULT_ERROR("오류가 발생하였습니다."),
    INVALID_NUMBER_FORMAT("숫자만 입력할 수 있습니다."),
    INPUT_WINNING_6_NUMBERS("당첨번호는 6개 입력해주셔야 됩니다."),
    INPUT_WINNING_ONLY_NUMBERS("당첨번호는 숫자로 입력해주셔야 합니다."),
    INPUT_WINNING_EMPTY("당첨번호에 빈문자열을 입력받았습니다."),
    INPUT_1_TO_45("번호는 1부터 45 사이의 숫자여야 합니다."),
    INPUT_DUPLICATION("로또 번호가 중복으로 입력되었습니다."),
    INPUT_DUPLICATION_Bouns("보너스 번호는 로또 번호와 중복될 수 없습니다."),


}