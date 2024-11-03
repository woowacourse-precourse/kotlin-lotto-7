package lotto

class Broadcast {
    fun printLottoQuantity(count: Int) {
        println("\n$count$PURCHASE_LOTTO_COUNT_MESSAGE")
    }

    companion object {
        const val PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
    }
}