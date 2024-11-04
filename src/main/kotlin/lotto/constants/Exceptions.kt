package lotto.constants

object Exceptions {
    private const val TITLE = "[ERROR]"

    const val INVALID_NUMBER = "$TITLE 정수 값을 입력해주세요."

    const val NOT_BETWEEN_PRICE_RANGE = "$TITLE 천원-십만원 사이 금액을 입력해주세요."
    const val INVALID_PRICE_UNIT = "$TITLE 1000원 단위로 입력해주세요."

    const val NOT_BETWEEN_NUMBER_RANGE = "$TITLE 1-45 사이 숫자를 입력해주세요."

    const val INVALID_NUMBERS_SIZE = "$TITLE 로또 번호는 6개여야 합니다."
    const val DUPLICATED_NUMBERS = "$TITLE 중복 숫자를 제거해주세요."
}