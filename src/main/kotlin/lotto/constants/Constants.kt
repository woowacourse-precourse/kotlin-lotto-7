package lotto.constants

object InputConstants {
    const val PURCHASE_PRICE_MSG = "구입금액을 입력해 주세요."
    const val WINNING_NUMBERS_MSG = "당첨 번호를 입력해 주세요."
    const val BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요."
    const val PURCHASED_QUANTITY_MSG = "개를 구매했습니다."
}

object OutputConstants {
    const val WINNING_RESULT_MSG = "당첨 통계\n" + "---"
    const val PROFIT_RATE_MSG = "총 수익률은 %s입니다."
    const val PERCENT = "%"
    const val COUNT = "개"
    const val TWO_DECIMAL_FORMAT = "%.2f"
}


object ErrorConstants {
    const val ERROR_PRICE_ONLY_NUMERIC = "[ERROR] 구입금액은 숫자만 가능합니다."
    const val ERROR_PRICE_NOT_MULTIPLE_OF_1000 = "[ERROR] 구입 금액은 1000원 단위만 가능합니다."
    const val ERROR_PURCHASE_PRICE_MINIMUM = "[ERROR] 구입 금액은 1000원 이상이여야 합니다."

    const val ERROR_WINNING_NUMBERS_ONLY_NUMERIC = "[ERROR] 당첨번호는 숫자만 가능합니다."
    const val ERROR_WINNING_NUMBERS_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다"
    const val ERROR_WINNING_NUMBERS_DUPLICATE = "[ERROR] 당첨 번호는 중복된 숫자가 없어야 합니다."

    const val ERROR_BONUS_NUMBER_ONLY_NUMERIC = "[ERROR] 보너스번호는 숫자만 가능합니다."
    const val ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1-45 사이 입니다."

}

object LottoConstants {
    const val LOTTO_PRICE = 1000
    const val COMMA = ","
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    const val LOTTO_NUMBER_RANGE = 6
}

object RankingConstants {
    const val FIFTH_PRIZE = 5_000
    const val FOURTH_PRIZE = 50_000
    const val THIRD_PRIZE = 1_500_000
    const val SECOND_PRIZE = 30_000_000
    const val FIRST_PRIZE = 2_000_000_000

    const val FIFTH_MSG = "3개 일치 (5,000원) - "
    const val FOURTH_MSG = "4개 일치 (50,000원) - "
    const val THIRD_MSG = "5개 일치 (1,500,000원) - "
    const val SECOND_MSG = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    const val FIRST_MSG = "6개 일치 (2,000,000,000원) - "
}
