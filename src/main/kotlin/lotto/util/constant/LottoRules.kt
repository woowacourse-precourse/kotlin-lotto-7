package lotto.util.constant

object LottoRules {
    const val AMOUNT_UNIT = 1000
    const val ZERO = 0
    const val ZERO_DOUBLE = 0.0 // Float로 계산했을때 정밀 소수점 계산이 안됐음
    const val MAX_AMOUNT = 1000000000

    const val DELIMITER = ","

    const val LOTTO_NUMBER_COUNT = 6
    const val LOTTO_NUMBER_MIN = 1
    const val LOTTO_NUMBER_MAX = 45
    val LOTTO_NUMBER_RANGE = LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX

    const val MATCHED_SIX = 6
    const val MATCHED_FIVE = 5
    const val MATCHED_FOUR = 4
    const val MATCHED_THREE = 3

    const val RANK_FIRST = 1
    const val RANK_SECOND = 2
    const val RANK_THIRD = 3
    const val RANK_FOURTH = 4
    const val RANK_FIFTH = 5
    const val OUT_OF_RANK = 0

    const val PERCENTAGE = 100.0
    const val YIELD_FORMAT = "%,.1f"
    const val COUNT_FORMAT = "%,d"

    const val FIRST_PRIZE_MONEY = 2000000000
    const val SECOND_PRIZE_MONEY = 30000000
    const val THIRD_PRIZE_MONEY = 1500000
    const val FOURTH_PRIZE_MONEY = 50000
    const val FIFTH_PRIZE_MONEY = 5000
}