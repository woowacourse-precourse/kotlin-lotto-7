package util

enum class Input(private val msg: String) {
    INPUT_PAY("구입금액을 입력해 주세요.");

    override fun toString(): String = msg
}