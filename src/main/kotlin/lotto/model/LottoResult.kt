package lotto.model

object LottoResult {
    var first: Int = 0
    var second: Int = 0
    var third: Int = 0
    var fourth: Int = 0
    var fifth: Int = 0
    var priceRatio: Float = 0f

    fun reset() {
        first = 0
        second = 0
        third = 0
        fourth = 0
        fifth = 0
        priceRatio = 0f
    }
}