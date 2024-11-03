package lotto

class Validator {
    fun validatePurchasePrice(input: String): Int? {
        return runCatching {
            val price = input.toInt()
            require(price % 1000 == 0) { ERROR_INCORRECT_UNIT }
            price
        }.onFailure {
            println(it.message ?: ERROR_UNVALIDATED_NUMBER)
        }.getOrNull()
    }

    companion object {
        private const val ERROR_INCORRECT_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다."
        private const val ERROR_UNVALIDATED_NUMBER = "[ERROR] 숫자를 올바르게 입력해 주세요."
    }
}