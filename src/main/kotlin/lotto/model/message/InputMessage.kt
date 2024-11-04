package lotto.model.message

enum class InputMessage(val message: String) {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요.")
}