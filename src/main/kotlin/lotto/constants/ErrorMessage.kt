package lotto.constants

import lotto.utils.LottoGenerator

object ErrorMessage {

    // PurchaseMoney
    const val PURCHASE_MONEY_NOT_IN_1000_UNITS = "[ERROR] 구입 금액은 ${LottoGenerator.LOTTO_MONEY_UNIT}단위의 양수만 입력 가능합니다."
    const val PURCHASE_MONEY_LESS_THAN_MINIMUM = "[ERROR] 구입 금액은 ${LottoGenerator.LOTTO_MONEY_MINIMUM}원 이상만 입력 가능합니다."
    const val PURCHASE_MONEY_EXCEEDS_MAXIMUM = "[ERROR] 한번에 구입 가능한 최대 금액은 ${LottoGenerator.LOTTO_MONEY_MAXIMUM}원을 넘길 수 없습니다."
    const val PURCHASE_MONEY_INVALID_FORMAT = "[ERROR] 구입 금액은 ${LottoGenerator.LOTTO_MONEY_MINIMUM}원 이상의 금액만 입력 가능합니다."

}