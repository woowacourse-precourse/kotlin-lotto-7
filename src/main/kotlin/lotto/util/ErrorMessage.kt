package lotto.util

object ErrorMessage {
    private const val ERROR_MESSAGE_HEADER = "[ERROR] "

    const val ERROR_INPUT_NOT_NUMERIC = "${ERROR_MESSAGE_HEADER}올바른 숫자가 아닙니다."
    const val ERROR_MONEY_NOT_DIVISIBLE = "${ERROR_MESSAGE_HEADER}구입 금액이 로또의 가격으로 나누어 떨어지지 않습니다."
}
