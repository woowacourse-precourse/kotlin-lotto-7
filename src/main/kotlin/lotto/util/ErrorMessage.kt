package lotto.util

object ErrorMessage {
    private const val ERROR_PREFIX = "[ERROR] "

    const val INPUT_NOT_NUMERIC = "${ERROR_PREFIX}올바른 숫자가 아닙니다."
    const val MONEY_IS_NEGATIVE = "${ERROR_PREFIX}구입 금액은 음수일 수 없습니다."
    const val MONEY_NOT_ENOUGH = "${ERROR_PREFIX}구입 금액이 부족합니다."
    const val MONEY_NOT_DIVISIBLE = "${ERROR_PREFIX}구입 금액이 로또의 가격으로 나누어 떨어지지 않습니다."

    const val LOTTO_NUMBERS_COUNT_MISMATCH = "${ERROR_PREFIX}로또 번호는 ${Constant.LOTTO_NUMBERS_COUNT}개여야 합니다."
    const val LOTTO_NUMBERS_NOT_DISTINCT = "${ERROR_PREFIX}중복되는 로또 번호가 없어야 합니다."
    const val LOTTO_NUMBER_NOT_IN_RANGE = "${ERROR_PREFIX}로또 번호는 ${Constant.LOTTO_NUMBERS_MIN} 이상 ${Constant.LOTTO_NUMBERS_MAX} 이하여야 합니다."
}
