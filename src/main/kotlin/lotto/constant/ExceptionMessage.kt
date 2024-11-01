package lotto.constant

object ExceptionMessage {
    const val ERROR_MESSAGE_DEFAULT = "알 수 없는 오류가 발생했습니다."

    // 검증 관련
    const val ERROR_NOT_POSITIVE = "돈은 양수로 입력해야 합니다."
    const val ERROR_NOT_NUMBER = "입력 값이 숫자가 아니거나 너무 큽니다."

    // Lotto 관련
    const val ERROR_NOT_ITEM_LENGTH = "로또 번호는 6개여야 합니다."
    const val ERROR_NOT_LOTTO_NUMBER = "로또 번호는 1부터 45까지 가능합니다."
    const val ERROR_DUPLICATE_NUMBER = "로또 번호는 중복될 수 없습니다."
    const val ERROR_DIVISION = "지불한 비용은 로또 가격(${LottoRule.PRICE})으로 나누어 떨어져야 합니다."
}
