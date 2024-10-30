package lotto.view

class OutputView {

    fun printPurchaseAmountPrompt() {
        println("구입금액을 입력해 주세요.")
    }

    fun printNumberOfPurchase(numberOfPurchase: Int) {
        println()
        println("${numberOfPurchase}개를 구매했습니다.")
    }

}