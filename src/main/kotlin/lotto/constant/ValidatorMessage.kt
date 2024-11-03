package lotto.constant

enum class ValidatorMessage(val message: String) {
    INVALID_INPUT("잘못된 입력입니다."),
    DUPLICATE_NUM("중복된 번호가 존재합니다."),
    INVALID_COUNT_NUM("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_RANGE_NUM("로또 번호의 범위는 1~45입니다.");

    fun display() {
        println("[Error] $message")
    }
}