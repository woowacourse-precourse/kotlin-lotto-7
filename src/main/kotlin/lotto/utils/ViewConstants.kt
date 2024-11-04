package lotto.utils

enum class InputUserGuide(private val transmission: String) {
    MONEY("구입금액을 입력해 주세요."),
    NUMBER("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.");

    override fun toString(): String = transmission
}

enum class OuputString(private val transmission: String) {
    TRY_COUNT("개를 구매했습니다.");

    override fun toString(): String = transmission
}