package domain.enums

enum class Process(private val msg: String) {
    PAY("구입 금액"),
    WINNING_NUMBER("당첨 번호"),
    BONUS_NUMBER("보너스 번호");

    override fun toString(): String = msg
}