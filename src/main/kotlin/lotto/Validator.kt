package lotto

class Validator {
    fun validatePurchasePrice(inputPrice: String): Int? {
        return runCatching {
            val price = inputPrice.toInt()
            require(price % 1000 == 0) { ERROR_INCORRECT_UNIT }
            price
        }.onFailure {
            println(it.message ?: ERROR_UNVALIDATED_NUMBER)
        }.getOrNull()
    }

    fun validateWinningNumbers(inputNumbers: String): List<Int>? {
        return runCatching {
            val numbers = inputNumbers.split(",").map { it.trim().toInt() }
            NumberValidation.validate(numbers)
            numbers
        }.onFailure {
            println(it.message ?: ERROR_UNVALIDATED_NUMBER)
        }.getOrNull()
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int? {
        return runCatching {
            val bonusNumber = input.trim().toInt()
            require(NumberValidation.RANGE.isValid(listOf(bonusNumber))){NumberValidation.RANGE.errorMessage}
            require(bonusNumber !in winningNumbers) { ERROR_BONUS_DUPLICATE }
            bonusNumber
        }.onFailure {
            println(it.message ?: ERROR_UNVALIDATED_NUMBER)
        }.getOrNull()
    }

    companion object {
        private const val ERROR_INCORRECT_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다."
        private const val ERROR_UNVALIDATED_NUMBER = "[ERROR] 숫자를 올바르게 입력해 주세요."
        private const val ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."
    }
}