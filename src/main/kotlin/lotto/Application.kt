package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object LottoConfig {
    const val LOTTO_PRICE = 1000
    const val LOTTO_NUMBER_COUNT = 6
    const val MIN_NUMBER = 1
    const val MAX_NUMBER = 45
}

object Message {
    const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    const val INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    const val ERROR_INVALID_AMOUNT = "구입 금액은 1,000원 단위여야 합니다."
    const val ERROR_INVALID_MINIMUM_AMOUNT = "구입 금액은 1,000원 이상이어야 합니다."
    const val ERROR_INVALID_WINNING_NUMBERS = "당첨 번호는 중복되지 않는 6개의 숫자여야 합니다."
    const val ERROR_INVALID_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_INVALID_BONUS_NUMBER = "보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_INVALID_NUMBER_FORMAT = "숫자만 입력 가능합니다."
    const val ERROR_DUPLICATE_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복될 수 없습니다."
    const val RESULT_HEADER = "\n당첨 통계\n---"
    const val RESULT_FORMAT = "%s (%,d원) - %d개"
    const val PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다."
}

object PrizeConfig {
    const val FIRST_PRIZE = 2_000_000_000
    const val SECOND_PRIZE = 30_000_000
    const val THIRD_PRIZE = 1_500_000
    const val FOURTH_PRIZE = 50_000
    const val FIFTH_PRIZE = 5_000
}

object MatchConfig {
    const val FIRST_MATCH = 6
    const val SECOND_MATCH = 5
    const val THIRD_MATCH = 5
    const val FOURTH_MATCH = 4
    const val FIFTH_MATCH = 3
    const val NO_MATCH = 0
}

object RankDescription {
    const val FIRST = "6개 일치"
    const val SECOND = "5개 일치, 보너스 볼 일치"
    const val THIRD = "5개 일치"
    const val FOURTH = "4개 일치"
    const val FIFTH = "3개 일치"
    const val NONE = ""
}
