package lotto.view

import lotto.domain.Lotto

object OutputView {
    fun printPurchaseAmount(amount: Int) {
        println("" + amount + OUTPUT_PURCHASE_AMOUNT_MESSAGE)
    }

    fun printLottoNumbers(lotto: Lotto) {
        val numbers = lotto.getNumbers()
        println(numbers.sorted())
    }

    private const val OUTPUT_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다."
}