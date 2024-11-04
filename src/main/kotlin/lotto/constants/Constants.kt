package lotto.constants

object Constants {
    // 입, 출력 메시지
    const val PRICE_INPUT_MSG = "구입금액을 입력해 주세요."
    const val WINNING_NUMBERS_INPUT_MSG = "당첨 번호를 입력해 주세요."
    const val BONUS_NUMBER_INPUT_MSG = "보너스 번호를 입력해 주세요."

    // 매직넘버, 구분자
    const val PRICE_UNIT = 1000

    const val DELIMITER = ","

    const val MIN_NUMBER = 1
    const val MAX_NUMBER = 45
    const val LOTTO_SIZE = 6

    // 순위 값
    const val MATCH_COUNT_FIRST = 6
    const val MATCH_COUNT_SECOND = 5
    const val MATCH_COUNT_THIRD = 5
    const val MATCH_COUNT_FOURTH = 4
    const val MATCH_COUNT_FIFTH = 3

    const val PRIZE_FIRST = 2_000_000_000
    const val PRIZE_SECOND = 30_000_000
    const val PRIZE_THIRD = 1_500_000
    const val PRIZE_FOURTH = 50_000
    const val PRIZE_FIFTH = 5_000
}