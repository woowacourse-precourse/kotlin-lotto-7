package lotto.domain.exception

import lotto.domain.model.Lotto
import lotto.domain.model.Lotto.Companion.VALID_LOTTO_NUMBER_LENGTH
import lotto.domain.model.Lotto.Companion.VALID_LOTTO_NUMBER_RANGE

object ExceptionMessages {
    const val DEFAULT_EXCEPTION_MESSAGE = "오류가 발생 했습니다. 다시 입력해 주세요."
    const val BUDGET_NOT_DIVISIBLE_BY_LOTTO_PRICE =
        "금액이 로또 금액(${Lotto.LOTTO_PRICE})으로 나누어 떨어지도록 입력해주세요."
    const val BUDGET_NEEDS_TO_BE_BIGGER_THAN_ZERO = "금액은 0보다 커야합니다."
    const val INVALID_NUMBER_FORMAT = "올바른 숫자 형식을 입력해 주세요."
    const val INVALID_LOTTO_NUMBER_LENGTH = "로또 번호는 ${VALID_LOTTO_NUMBER_LENGTH}개여야 합니다."
    val NUMBER_OUT_OF_VALID_LOTTO_RANGE_EXISTS =
        "로또 번호는 ${VALID_LOTTO_NUMBER_RANGE.first}와 ${VALID_LOTTO_NUMBER_RANGE.last} 사이의 값이어야 합니다."
    const val DUPLICATE_NUMBER_EXISTS = "로또 번호에 중복이 없어야 합니다."
}
