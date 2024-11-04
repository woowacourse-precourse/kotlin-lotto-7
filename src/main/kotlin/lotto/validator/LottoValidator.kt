package lotto.validator

import lotto.domain.entity.Lotto
import lotto.domain.entity.Lotto.Companion.toLottoNumbers

class LottoValidator {
    fun validatePurchasePrice(input: String): Int {
        require(input.isValidNumber()) { INVALID_INT_NUMBER_EXCEPTION_MSG }
        val price = input.toInt()
        require(price >= MIN_PURCHASE_PRICE && price % 1000 == 0) { INVALID_PRICE_RANGE_EXCEPTION_MSG }
        return input.toInt()
    }

    fun validateWinningLotto(input: String): Lotto {
        require(input.isValidNumbers()) { INVALID_NUMBERS_EXCEPTION_MSG }
        val inputNumbers = input.split(DELIMITER).map { it.toInt() }
        return inputNumbers.toLottoNumbers()
    }

    fun validateBonusNumber(input: String, winLotto: Lotto): Int {
        require(input.isValidNumber()) { INVALID_INT_NUMBER_EXCEPTION_MSG }
        val bonusNumber = input.toInt()
        require(bonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { OVER_RANGE_EXCEPTION_MSG }
        require(bonusNumber !in winLotto.getNumbers()) { DUPLICATE_BONUS_NUMBER_EXCEPTION_MSG }
        return bonusNumber
    }

    companion object {
        private fun String.isValidNumber() = this.all { it.isDigit() }

        private fun String.isValidNumbers(): Boolean =
            try {
                this.split(',').map { it.toInt() }
                true
            } catch (e: NumberFormatException) {
                false
            }

        private const val DELIMITER = ','
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val MIN_PURCHASE_PRICE = 1000

        private const val INVALID_INT_NUMBER_EXCEPTION_MSG = "[ERROR] 유효하지 않은 정수입니다."
        private const val INVALID_NUMBERS_EXCEPTION_MSG = "[ERROR] 유효하지 않은 당첨 번호 리스트입니다."
        private const val OVER_RANGE_EXCEPTION_MSG = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        private const val INVALID_PRICE_RANGE_EXCEPTION_MSG = "[ERROR] 구입 금액은 1000원 이상의 1000으로 나누어지는 금액이어야 합니다."
        private const val DUPLICATE_BONUS_NUMBER_EXCEPTION_MSG = "[ERROR] 보너스 번호가 당첨 번호에 있습니다."
    }
}