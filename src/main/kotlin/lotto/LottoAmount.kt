package lotto

class LottoAmount(private val amount: Int) {
    var lottoAmount = amount
        private set

    init {
        require(amount > 0) { "[ERROR] 로또 구매 금액은 0원 이상이어야 합니다." }
        require(amount % 1_000 == 0) { "[ERROR] 로또 구매 금액은 천 원 단위로 입력 가능합니다." }
    }
}