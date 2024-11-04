package lotto.constants

object ErrorMessages {
    const val ERROR_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다."
    const val ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."
    const val ERROR_LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복이 없어야 합니다."

    const val ERROR_LOTTO_MINIMUM_AMOUNT = "[ERROR] 로또 구매 금액은 0원 이상이어야 합니다."
    const val ERROR_LOTTO_THOUSAND_UNIT_AMOUNT = "[ERROR] 로또 구매 금액은 천 원 단위로 입력 가능합니다."

    const val ERROR_LOTTO_PRIZE_MATCHING_COUNT_RANGE = "[ERROR] 로또 번호 맞은 개수가 범위 밖입니다."

    const val ERROR_BLANK = "[ERROR] %s은 공백이 될 수 없습니다."
    const val ERROR_INTEGER = "[ERROR] %s는 정수만 입력할 수 있습니다."
}