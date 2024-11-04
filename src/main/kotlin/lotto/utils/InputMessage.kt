package lotto.utils

enum class InputMessage(private val message: String) {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER("보너스 볼을 입력해 주세요.");


    fun getMessage(): String {
        return message
    }

}