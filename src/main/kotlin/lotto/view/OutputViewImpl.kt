package lotto.view

class OutputViewImpl : OutputView {

    override fun printPurchaseCount(count: Int)  = println("${count}개를 구매했습니다.")
}