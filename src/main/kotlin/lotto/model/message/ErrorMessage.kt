package lotto.model.message

enum class ErrorMessage(val message: String) {
    PURCHASE_PRICE_1000("구입 금액은 1000원 단위여야 합니다."),
    DEFAULT_ERROR("오류가 발생하였습니다."),
    EMPTY_PURCHASE_PRICE("숫자를 입력해주세요.")
}