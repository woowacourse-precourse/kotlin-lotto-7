package lotto.global

enum class Error(val message: String) {
    EMPTY_INPUT("[ERROR] 입력값이 없습니다. 다시 입력해 주세요."),
    CONTAINS_GAP("[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."),
    NOT_NUMERIC("[ERROR] 숫자만 입력해 주세요."),
    BELOW_MINIMUM_AMOUNT("[ERROR] 로또 구매 금액은 최소 %,d원 이상이어야 합니다.".format(LOTTO_MINIMUM_AMOUNT)),
    NOT_THOUSAND_UNIT("[ERROR] 로또 구매 금액은 %,d원 단위여야 합니다.".format(LOTTO_PRICE)),
    ABOVE_MAXIMUM_AMOUNT("[ERROR] 로또 구매 금액은 %,d원 이하이어야 합니다.".format(LOTTO_MAXIMUM_AMOUNT.toInt())),
    NOT_SIX_NUMBERS("[ERROR] 로또 번호는 %d개여야 합니다.".format(LOTTO_NUMBERS_SIZE)),
    HAS_DUPLICATE_NUMBERS("[ERROR] 번호는 중복되지 않아야 합니다."),
    NUMBERS_OUT_OF_RANGE("[ERROR] 당첨 번호는 %d부터 %d사이의 숫자여야 합니다.".format(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER)),
    BONUS_OUT_OF_RANGE("[ERROR] 보너스 번호는 %d부터 %d사이의 숫자여야 합니다.".format(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER)),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않게 입력해 주세요.")
}