package lotto.util

class ExceptionConstants {
    companion object {
        const val ERROR_INVALID_WINNING_NUMBERS_COUNT = "[ERROR] 로또 번호는 6개여야 합니다."
        const val ERROR_INVALID_WINNING_NUMBERS_RANGE = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다."
        const val ERROR_DUPLICATE_WINNING_NUMBERS = "[ERROR] 로또 번호는 중복될 수 없습니다."
        const val ERROR_EMPTY_WINNING_NUMBERS = "[ERROR] 당첨 번호가 비어 있습니다."
        const val ERROR_INVALID_DELIMITER = "[ERROR] 당첨 번호는 쉼표(,)로 구분해야 합니다."

        const val ERROR_INVALID_PURCHASE_AMOUNT = "[ERROR] 로또는 1,000원 단위로 입력해야 합니다."
        const val ERROR_EMPTY_PURCHASE_AMOUNT = "[ERROR] 구매 금액이 비어 있습니다."
        const val ERROR_NOT_A_NUMBER = "[ERROR] 구매 금액은 숫자여야 합니다."
        const val ERROR_OUT_OF_RANGE = "[ERROR] 구매 금액이 정수의 범위를 벗어납니다."

        const val ERROR_INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 1부터 45 사이여야 합니다."
        const val ERROR_DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다."
        const val ERROR_EMPTY_BONUS_NUMBERS = "[ERROR] 보너스 번호가 비어 있습니다."
    }
}