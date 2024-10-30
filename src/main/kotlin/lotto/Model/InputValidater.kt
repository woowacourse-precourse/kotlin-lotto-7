package lotto.Model

object InputValidater {

    fun validatePurchaseAmount(purchaseAmount: String) {
        if (!purchaseAmount.all { it.isDigit() }) {
            throw IllegalArgumentException("[ERROR] 입력 값은 정수여야 합니다.")
        }
        if (purchaseAmount.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 입력 값은 1000으로 나누어 떨어져야 합니다.")
        }
    }
}