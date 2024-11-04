package lotto.domain

class PurchaseAmount(private val money: Int) {
    init {
        require(money > 0) { ERROR_NEGATIVE_NUMBER_MESSAGE }
    }

    fun getMoney(): Int = money

    fun getCount(): Int = money / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000

        private const val ERROR_NEGATIVE_NUMBER_MESSAGE = "[ERROR] 0보다 큰 값을 입력해야 합니다."
    }
}