package lotto.util

object ErrorMessages {
    const val INVALID_NUMBER_SIZE = "[ERROR] 로또 번호는 6개여야 합니다."
    const val DUPLICATE_NUMBERS = "[ERROR] 로또 번호는 중복되지 않아야 합니다."
    const val OUT_OF_RANGE = "[ERROR] 모든 로또 번호는 1부터 45 사이여야 합니다."
    const val NOT_SORTED = "[ERROR] 로또 번호는 오름차순으로 정렬되어 있어야 합니다."
    const val NULL_PRICE = "[ERROR] 구입금액을 입력해 주세요."
    const val NOT_INT = "[ERROR] 입력이 숫자가 아닙니다."
    const val MINIMUM_PRICE = "[ERROR] 로또 한 개의 가격은 1000원 이상이어야 합니다"
    const val NULL_LOTTO_NUMBER = "[ERROR] 당첨 번호를 입력해 주세요."
    const val NULL_BONUS_NUMBER = "[ERROR] 보너스 번호를 입력해 주세요."
    const val DUPLICATED_BONUS = "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."
}