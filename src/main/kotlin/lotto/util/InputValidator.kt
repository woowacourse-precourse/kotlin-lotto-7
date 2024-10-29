package lotto.util

class InputValidator {

    fun validatePurchaseAmount(purchaseAmount: String) {
        val parsedPurchaseAmount = purchaseAmount.toIntOrNull()

        require(parsedPurchaseAmount != null) {
            "[ERROR] 구입 금액은 정수 형태여야 합니다."
        }
        require(parsedPurchaseAmount >= 1000 && parsedPurchaseAmount % 1000 == 0) {
            "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."
        }
    }

}