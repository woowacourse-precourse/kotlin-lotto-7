package lotto.util.constant

object ErrorMessages {
    private const val ERROR_HEADER = "[ERROR]"

    const val AMOUNT_IS_NOT_EMPTY = "$ERROR_HEADER 구입 금액은 빈 값이 될 수 없습니다."
    const val AMOUNT_IS_NUMERIC = "$ERROR_HEADER 구입 금액은 숫자여야 합니다."
    const val AMOUNT_IS_MULTIPLE_OF_THOUSAND = "$ERROR_HEADER 구입 금액은 1,000원 단위여야 합니다."
    const val MAX_AMOUNT = "$ERROR_HEADER 구입 금액은 10억원 이하여야 합니다."

    const val LOTTO_NUMBER_NUMERIC = "$ERROR_HEADER 로또 번호는 자연수여야 합니다."
    const val LOTTO_NUMBER_DELIMITER = "$ERROR_HEADER 로또 번호는 쉼표로 구분해야 합니다."
    const val LOTTO_NUMBER_COUNT = "$ERROR_HEADER 로또 번호는 6개여야 합니다."
    const val LOTTO_NUMBER_RANGE = "$ERROR_HEADER 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val LOTTO_NUMBER_UNIQUE = "$ERROR_HEADER 로또 번호는 중복될 수 없습니다."

    const val BONUS_NUMBER_NUMERIC = "$ERROR_HEADER 보너스 번호는 자연수여야 합니다."
    const val BONUS_NUMBER_RANGE = "$ERROR_HEADER 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    const val BONUS_NUMBER_UNIQUE = "$ERROR_HEADER 보너스 번호는 로또 번호와 중복될 수 없습니다."
}