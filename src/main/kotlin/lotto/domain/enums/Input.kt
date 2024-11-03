package lotto.domain.enums

enum class Input(private val msg: String) {
    INPUT_PAY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    override fun toString(): String = msg
}