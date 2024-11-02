package lotto.view

import lotto.domain.Lotto
import lotto.domain.Lottos

object OutputView {
    fun printPurchaseAmount(amount: Int) {
        println("" + amount + OUTPUT_PURCHASE_AMOUNT_MESSAGE)
    }

    fun printLotto(lotto: Lotto) {
        val numbers = lotto.getNumbers().map { it.getNumber() }
        println(numbers.sorted())
    }

    fun printLottos(lottos: Lottos) {
        for (lotto in lottos.getLottos()) {
            printLotto(lotto)
        }
    }

    private const val OUTPUT_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다."
}