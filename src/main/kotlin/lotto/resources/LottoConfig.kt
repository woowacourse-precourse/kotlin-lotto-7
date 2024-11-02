package lotto.resources

enum class LottoConfig(val value: Int) {
    LOTTO_PRICE(1_000),
    LOTTO_LENGTH(6),
    LOTTO_START(1),
    LOTTO_END(45);

    companion object {
        val LOTTO_RANGE = LOTTO_START.value..LOTTO_END.value
    }
}