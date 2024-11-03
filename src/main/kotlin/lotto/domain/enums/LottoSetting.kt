package lotto.domain.enums

enum class LottoSetting(private val value: String) {
    LOTTO_MIN("1"),
    LOTTO_MAX("45"),
    LOTTO_SIZE("6");

    fun value(): Int = value.toInt()
}