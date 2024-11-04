package lotto.constant

enum class InputMessage(val message: String) {
    MONEY("구입 금액을 입력해 주세요."),
    WINNING_NUM("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.");

    fun display() {
        println(message)
    }
}