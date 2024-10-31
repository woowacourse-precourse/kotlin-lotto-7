package lotto.domain.exception

import lotto.Lotto

object ExceptionMessages {
    const val DEFAULT_EXCEPTION_MESSAGE = "오류가 발생 했습니다. 다시 입력해 주세요."
    const val BUDGET_NOT_DIVISIBLE_BY_LOTTO_PRICE =
        "금액이 로또 금액(${Lotto.LOTTO_PRICE})으로 나누어 떨어지도록 입력해주세요."
    const val BUDGET_NEEDS_TO_BE_BIGGER_THAN_ZERO = "금액은 0보다 커야합니다."
    const val INVALID_NUMBER_FORMAT = "올바른 숫자 형식을 입력해 주세요."
}
