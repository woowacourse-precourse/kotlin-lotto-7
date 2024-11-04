package lotto.validation

import lotto.extensions.*

object InputValidator {

    fun validatePurchaseAmount(input: String) {
        val message = when {
            input.isEmpty() -> "[ERROR] 입력값이 없습니다. 다시 입력해 주세요."
            input.containGap() -> "[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."
            input.isNotNumeric() -> "[ERROR] 숫자만 입력해 주세요."
            input.isBelowMinimumAmount() -> "[ERROR] 로또 구매 금액은 최소 1000원 이상이어야 합니다."
            input.isNotThousandUnit() -> "[ERROR] 로또 구매 금액은 1000원 단위여야 합니다."
            input.isAboveMaximumAmount() -> "[ERROR] 로또 구매 금액은 1,000,000원 이하이어야 합니다."
            else -> return
        }
        throw IllegalArgumentException(message)
    }

    fun validateWinningNumbers(input: String) {
        val message = when {
            input.isEmpty() -> "[ERROR] 입력값이 없습니다. 다시 입력해 주세요."
            input.containGap() -> "[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."
            input.isNotNumbers() -> "[ERROR] 숫자만 입력해 주세요."
            input.hasNotSixNumbers() -> "[ERROR] 당첨 번호는 6개를 입력해 주세요."
            input.hasDuplicateNumbers() -> "[ERROR] 당첨 번호는 중복되지 않게 입력해 주세요."
            input.areNotNumbersInRange() -> "[ERROR] 당첨 번호는 1부터 45사이의 숫자여야 합니다."
            else -> return
        }
        throw IllegalArgumentException(message)
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>) {
        val message = when {
            input.isEmpty() -> "[ERROR] 입력값이 없습니다. 다시 입력해 주세요."
            input.containGap() -> "[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."
            input.isNotNumeric() -> "[ERROR] 숫자만 입력해 주세요."
            input.isNotNumberInRange() -> "[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다."
            input.isDuplicateBonusNumber(winningNumbers) -> "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않게 입력해 주세요."
            else -> return
        }
        throw IllegalArgumentException(message)
    }
}