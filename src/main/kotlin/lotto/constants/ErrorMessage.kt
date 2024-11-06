package lotto.constants

import lotto.utils.InputManager
import lotto.utils.LottoGenerator

object ErrorMessage {

    // PurchaseMoney
    const val PURCHASE_MONEY_NOT_IN_1000_UNITS = "[ERROR] 구입 금액은 ${LottoGenerator.LOTTO_MONEY_UNIT}단위의 양수만 입력 가능합니다."
    const val PURCHASE_MONEY_LESS_THAN_MINIMUM = "[ERROR] 구입 금액은 ${LottoGenerator.LOTTO_MONEY_MINIMUM}원 이상만 입력 가능합니다."
    const val PURCHASE_MONEY_EXCEEDS_MAXIMUM = "[ERROR] 한번에 구입 가능한 최대 금액은 ${LottoGenerator.LOTTO_MONEY_MAXIMUM}원을 넘길 수 없습니다."
    const val PURCHASE_MONEY_INVALID_FORMAT = "[ERROR] 구입 금액은 ${LottoGenerator.LOTTO_MONEY_MINIMUM}원 이상의 금액만 입력 가능합니다."

    // LottoNumber
    const val LOTTO_NUMBER_NOT_ONE_SET_SIZE = "[ERROR] 로또 번호는 ${LottoGenerator.LOTTO_ONE_SET_SIZE}개여야 합니다."
    const val LOTTO_NUMBER_NOT_IN_RANGE = "[ERROR] 로또 번호는 " +
            "${LottoGenerator.LOTTO_START_INCLUSIVE_NUMBER}~${LottoGenerator.LOTTO_END_INCLUSIVE_NUMBER}" +
            " 사이의 정수만 가능합니다."
    const val LOTTO_NUMBER_OVERLAP = "[ERROR] 로또 번호는 중복될 수 없습니다."

    // WinningNumbers
    const val WINNING_NUMBER_NOT_ONE_SET_SIZE = "[ERROR] 당첨 번호는 ${LottoGenerator.LOTTO_ONE_SET_SIZE}개여야 합니다."
    const val WINNING_NUMBER_NOT_IN_RANGE = "[ERROR] 당첨 번호는 " +
            "${LottoGenerator.LOTTO_START_INCLUSIVE_NUMBER}~${LottoGenerator.LOTTO_END_INCLUSIVE_NUMBER}" +
            " 사이의 정수만 가능합니다."
    const val WINNING_NUMBER_OVERLAP = "[ERROR] 당첨 번호는 중복될 수 없습니다."
    const val WINNING_NUMBER_INVALID_FORMAT = "[ERROR] 당첨 번호는 공백 없이" +
            "${LottoGenerator.LOTTO_START_INCLUSIVE_NUMBER}~${LottoGenerator.LOTTO_END_INCLUSIVE_NUMBER}" +
            " 사이의 정수만 ${InputManager.INPUT_WINNING_NUMBERS_SEPARATOR} 구분으로" +
            " ${LottoGenerator.LOTTO_ONE_SET_SIZE}개 입력 가능합니다."

}