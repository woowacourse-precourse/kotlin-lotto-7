package lotto.view

import lotto.model.Lotto

class OutputView {
    fun printPurchaseAmountRequest() {
        println("구매금액을 입력해 주세요.")
    }

    fun printPurchaseQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun printPurchaseLotto(lottos: List<Lotto>, quantity: Int) {
        println("")
        printPurchaseQuantity(quantity)
        lottos.forEach {
            println(it.getLotto())
        }
    }

    fun printWinningLottoRequest() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun printBonusNumberRequest() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun printTotalRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${rateOfReturn}%입니다.")
    }
}