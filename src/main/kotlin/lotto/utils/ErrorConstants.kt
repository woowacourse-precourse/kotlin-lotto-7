package lotto.utils

object ErrorConstants {
    const val NOT_NUMBER = "[ERROR] 정수형 숫자만 입력 가능합니다. 천 원 단위로 입력해주세요."
    const val NEGATIVE_NUMBER = "[ERROR] 외상은 취급하지 않습니다."
    const val NOT_DIVIDED = "[ERROR] 로또는 1장당 1000원입니다. 잔돈은 필요 없어요!"
    const val LIMIT_OF_PURCHASE = "[ERROR] 1인당 최대 구매 가능 금액은 10만원입니다."
    const val LOTTO_INPUT_FORMAT = "[ERROR] 로또 번호는 1에서 45 사이의 값으로, (,)로 구분해 6자리 입력해주세요."
    const val LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다."
    const val LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1에서 45 이내여야 합니다."
    const val LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복되면 안됩니다."
    const val BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1에서 45 사이의 값을 입력해주세요."
}