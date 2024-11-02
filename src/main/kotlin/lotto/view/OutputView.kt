package lotto.view

object OutputView {
    fun printPurchaseAmount(amount: Int) {
        println("" + amount + OUTPUT_PURCHASE_AMOUNT_MESSAGE)
    }

    private const val OUTPUT_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다."
}