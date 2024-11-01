package lotto.domain

class LottoPurchaseMoney(purchasePrice: Int) : Money(purchasePrice) {
    init {
        require(amount % Lotto.PRICE == 0) { ERROR_DIVISION }
    }

    companion object {
        const val ERROR_DIVISION = "[ERROR] 지불한 비용은 로또 가격(${Lotto.PRICE})으로 나누어 떨어져야 합니다."
    }
}