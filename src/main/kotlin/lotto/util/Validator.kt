package lotto.util

class Validator {
    fun validatePriceRange(tempPrice: Int) =
        require(tempPrice in MIN_PRICE..MAX_PRICE) { "[ERROR] 천원-십만원 사이 금액을 입력해주세요." }

    fun validatePriceUnit(tempPrice: Int) =
        require(tempPrice % MIN_PRICE == 0) { "[ERROR] 1000원 단위로 입력해주세요." }

    fun validateLottoNumberRange(tempWinningNumber: Int) =
        require(tempWinningNumber in MIN_NUMBER..MAX_NUMBER) { "[ERROR] 1-45 사이 숫자를 입력해주세요." }

    companion object {
        private const val MIN_PRICE = 1000
        private const val MAX_PRICE = 100000

        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}