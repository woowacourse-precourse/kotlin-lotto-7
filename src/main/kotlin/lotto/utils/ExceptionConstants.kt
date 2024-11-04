package lotto.utils

enum class intException(private val transmission: String) {
    NOT_INT("[ERROR] 구입 금액은 정수형 이여야 합니다."),
    NEGATIVE_INT("[ERROR] 구입 금액은 0이상 이여야 합니다."),
    BLANK("[ERROR] 구입 금액은 공백이 아니여야 합니다."),
    NOT_THOUSAND_UNIT("[ERROR] 구입 금액은 1000단위 이여야 합니다.");

    override fun toString() = transmission
}