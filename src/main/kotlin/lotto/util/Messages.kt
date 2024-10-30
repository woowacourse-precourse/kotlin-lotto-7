package lotto.util

object ErrorMessages {

    const val INVALID_PURCHASE_AMOUNT_FORMAT = "[ERROR] 구입 금액은 정수 형태여야 합니다."
    const val INVALID_PURCHASE_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."
    const val INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다."
    const val DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복되지 않아야 합니다."

}

object InputMessages {

    const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."

}

object InfoMessages {

    const val PURCHASE_AMOUNT_INFO = "개를 구매했습니다."

}