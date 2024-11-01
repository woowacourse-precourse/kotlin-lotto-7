package lotto.view

class OutputView {
    fun printLottoCount(count: Int) {
        println("$count$MESSAGE_LOTTO_COUNT")
    }

    companion object {
        const val MESSAGE_LOTTO_COUNT = "개를 구매했습니다."
    }
}
