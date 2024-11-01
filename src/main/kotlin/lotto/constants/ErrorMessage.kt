package lotto.constants

object ErrorMessage {
    const val PARSE_NUMBER_ERROR = "[ERROR] 숫자를 입력해 주세요."
    const val NON_POSITIVE_ERROR = "[ERROR] 자연수를 입력해 주세요."
    const val RANGE_ERROR = "[ERROR] 1~45 범위의 자연수를 입력해 주세요."
    const val MODULO_ERROR = "[ERROR] 1,000으로 나눌 수 있는 금액을 입력해 주세요."
    const val LOTTO_COUNT_ERROR = "[ERROR] 1~45 범위의 중복되지 않은 자연수 6개를 입력해 주세요."
    const val DUPLICATED_NUMBER = "[ERROR] 당첨된 숫자와 중복되지 않은 숫자를 입력해 주세요."
}