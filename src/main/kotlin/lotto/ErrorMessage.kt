package lotto

enum class ErrorMessage(val message : String) {
    MONEY_ERROR("[ERROR] 금액을 1000원 이상 다시 입력해 주세요."),
    MONEY_VALID_ERROR("[ERROR] 올바른 금액을 다시 입력해주세요."),
    MONEY_DIVIDE_ERROR("[ERROR] 금액의 단위는 1000원 단위로 입력해 주세요."),

    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_FORMAT_ERROR("[ERROR] 올바른 숫자를 입력해 주세요."),
    LOTTO_DUPLICATION_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이 입니다.")

}