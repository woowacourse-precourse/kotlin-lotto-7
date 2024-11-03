package lotto.Model

import lotto.Lotto

object InputValidater {

    fun validatePurchaseAmount(purchaseAmount: String) {
        if (!purchaseAmount.all { it.isDigit() }) {
            throw IllegalArgumentException(ERROR.INPUT_NOT_INT)
        }
        if (purchaseAmount.toInt() % Lotto.COST != 0) {
            throw IllegalArgumentException(ERROR.INPUT_NOT_DIVIDE_1000)
        }
    }

    fun validateFirstPrizeNumbers(lottoNumbers: List<String>) {
        val isLottoNumbersAllDigit = lottoNumbers.all { lottoNumber ->
            lottoNumber.all { it.isDigit() }
        }
        if (!isLottoNumbersAllDigit) {
            throw IllegalArgumentException(ERROR.INPUT_NOT_INT)
        }
    }

    fun validateBonusNumber(winningLotto: Lotto, rawBonusNumber: String) {
        if (!rawBonusNumber.all { it.isDigit() }) {
            throw IllegalArgumentException(ERROR.INPUT_NOT_INT)
        }
        val bonusNumber = rawBonusNumber.toInt()
        if (bonusNumber < Lotto.MIN_VALUE || bonusNumber > Lotto.MAX_VALUE) {
            throw IllegalArgumentException(ERROR.INPUT_BETWEEN_1_AND_45)
        }
        if (winningLotto.checkIfMatchBonusNumber(bonusNumber)) {
            throw IllegalArgumentException(ERROR.INPUT_DUPLICATE_WITH_WINNING_LOTTO)
        }
    }

    object ERROR {
        const val INPUT_NOT_INT = "[ERROR] 입력 값은 정수여야 합니다."
        const val INPUT_NOT_DIVIDE_1000 = "[ERROR] 입력 값은 1000으로 나누어 떨어져야 합니다."
        const val INPUT_BETWEEN_1_AND_45 = "[ERROR] 로또 번호는 1부터 45 사이의 값이어야 합니다."
        const val INPUT_DUPLICATE_WITH_WINNING_LOTTO = "[ERROR] 보너스 번호가 로또 번호와 중복입니다."
    }
}