package lotto.view

class OutputView {
    fun printPurchaseLottoCount(money: Int) {
        val lottoCount = money / 1000
        println("${lottoCount}$PRINT_PURCHASE_LOTTO_COUNT_MESSAGE")
        println()
    }

    companion object {
        const val PRINT_PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
    }


}