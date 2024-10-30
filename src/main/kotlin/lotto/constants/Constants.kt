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
}


object ErrorConstants {

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
