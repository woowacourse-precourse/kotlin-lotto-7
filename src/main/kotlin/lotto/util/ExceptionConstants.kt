package lotto.util

object ExceptionConstants {

    const val EXCEPTION_PREFIX = "[ERROR] "

    const val ERROR_MESSAGE_BONUS_NUMBER_TYPE = "보너스 번호는 숫자여야 합니다."
    const val ERROR_MESSAGE_BONUS_NUMBER_DUPLICATE = "보너스 번호는 당첨 번호에 겹치는 번호가 없어야 합니다."
    const val ERROR_MESSAGE_BONUS_NUMBER_RANGE = "보너스 번호는 1~45 사이의 숫자여야 합니다."

    const val ERROR_MESSAGE_LOTTO_NUMBER_SIZE = "로또 번호는 6개여야 합니다."
    const val ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATE = "중복된 로또 번호가 없어야 합니다."
    const val ERROR_MESSAGE_LOTTO_NUMBER_RANGE = "로또 번호는 1~45 사이의 숫자여야 합니다."

    const val ERROR_MESSAGE_PURCHASE_AMOUNT_TYPE = "구입 금액은 숫자여야 합니다."
    const val ERROR_MESSAGE_PURCHASE_AMOUNT_LESS_THAN_MINIMUM = "구입 금액은 1,000원 이상이어야 합니다."
    const val ERROR_MESSAGE_PURCHASE_AMOUNT_NOT_MULTIPLE = "구입 금액은 1,000원 단위여야 합니다."

    const val ERROR_MESSAGE_WINNING_NUMBER_SIZE = "당첨 번호는 6개여야 합니다."
    const val ERROR_MESSAGE_WINNING_NUMBER_TYPE = "당첨 번호는 숫자여야 합니다."
    const val ERROR_MESSAGE_WINNING_NUMBER_DUPLICATE = "중복된 당첨 번호가 없어야 합니다."
    const val ERROR_MESSAGE_WINNING_NUMBER_RANGE = "당첨 번호는 1~45 사이의 숫자여야 합니다."
}