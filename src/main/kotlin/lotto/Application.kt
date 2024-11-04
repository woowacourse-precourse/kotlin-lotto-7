package lotto

fun main() {
    val purchaseAmount = 5000 // 예시로 입력된 구입 금액

    try {
        Lotto.validatePurchaseAmount(purchaseAmount)
        println("구입 금액이 유효합니다. 로또를 구매할 수 있습니다.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
