package lotto.constants

object ErrorConstant {
    const val ERROR_PURCHASE_AMOUNT_IS_NOT_INTEGER = "[ERROR] 숫자를 입력해 주세요."
    const val ERROR_PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000 = "[ERROR] 구입 금액은 1000원 단위로 입력해 주세요."
    const val ERROR_PURCHASE_AMOUNT_NOT_ENOUGH = "[ERROR] 구입 금액은 1000원 이상부터 가능합니다."

    const val ERROR_WINNING_NUMBER_INVALID_CHARACTER = "[ERROR] 숫자와 ','만 포함되어야 합니다."
    const val ERROR_WINNING_NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다."
    const val ERROR_WINNING_NUMBER_DUPLICATED = "[ERROR] 로또 번호는 중복될 수 없습니다."

    const val ERROR_BONUS_NUMBER_INVALID_CHARACTER = "[ERROR] 숫자만 입력 가능합니다."
    const val ERROR_BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다."
    const val ERROR_BONUS_NUMBER_DUPLICATED = "[ERROR] 로또 번호는 중복될 수 없습니다."
}