package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.exception.InvalidInputException
import lotto.util.Constants

// 로또 번호를 관리
class Lotto(private val numbers: List<Int>) {
    init {
        validateNumbers(numbers)
    }

    // 로또 번호 자동 생성
    constructor() : this(
        Randoms.pickUniqueNumbersInRange(
            Constants.LOTTO_NUMBER_MIN,
            Constants.LOTTO_NUMBER_MAX,
            Constants.LOTTO_NUMBER_COUNT
        ).sorted()
    )

    // 로또 번호 유효성 검증
    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.size != Constants.LOTTO_NUMBER_COUNT) {
            throw InvalidInputException(Constants.ERROR_INVALID_LOTTO_NUMBERS_SIZE)
        }
        if (numbers.distinct().size != Constants.LOTTO_NUMBER_COUNT) {
            throw InvalidInputException(Constants.ERROR_DUPLICATE_NUMBER)
        }
        if (!numbers.all { it in Constants.LOTTO_NUMBER_MIN..Constants.LOTTO_NUMBER_MAX }) {
            throw InvalidInputException(Constants.ERROR_NUMBER_OUT_OF_RANGE)
        }
    }

    // 로또 번호 반환
    fun getNumbers(): List<Int> = numbers
}
