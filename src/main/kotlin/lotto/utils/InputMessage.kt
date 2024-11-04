package lotto.utils

enum class InputMessage(private val message: String) {
    INPUT_PRICE("\n구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER("\n보너스 볼을 입력해 주세요.");


    fun getMessage(): String {
        return message
    }

}