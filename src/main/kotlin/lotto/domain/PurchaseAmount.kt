package lotto.domain

class PurchaseAmount(private val money: Int) {
    init {
        require(money > 0) { ERROR_NEGATIVE_NUMBER_MESSAGE }
        require(money % LOTTO_PRICE == 0) { ERROR_INVALID_UNIT_MESSAGE }
    }

    fun getMoney(): Int = money

    fun getCount(): Int = money / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000

        private const val ERROR_NEGATIVE_NUMBER_MESSAGE = "[ERROR] 금액은 0보다 큰 값이어야 합니다."
        private const val ERROR_INVALID_UNIT_MESSAGE = "[ERROR] 금액은 1,000원 단위여야 합니다."
    }
}