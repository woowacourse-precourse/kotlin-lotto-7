package lotto.domain

class PurchaseAmount(private val money: Int) {
    init {}

    fun getMoney(): Int = money

    fun getCount(): Int = money / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}