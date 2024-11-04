package lotto

class Validator {
    companion object {
        fun validatePurchaseAmount(amount: String): Int {
            val purchaseAmount = parseAmount(amount)
            checkAmountIsAboveMinimum(purchaseAmount)
            checkAmountIsDivisibleByThousand(purchaseAmount)
            return purchaseAmount
        }

        private fun parseAmount(amount: String): Int {
            return amount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.")
        }

        private fun checkAmountIsAboveMinimum(amount: Int) {
            require(amount >= 1000) { "[ERROR] 구입 금액은 1000원 이상이어야 합니다." }
        }

        private fun checkAmountIsDivisibleByThousand(amount: Int) {
            require(amount % 1000 == 0) { "[ERROR] 구입 금액은 1000원 단위로 나누어 떨어져야 합니다." }
        }

    }
}
