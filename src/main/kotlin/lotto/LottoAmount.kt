package lotto

class LottoAmount(private val amount: Int) {

    init {
        require(amount % 1_000 == 0) { "[ERROR] 로또 구매 금액은 천 원 단위로 입력 가능합니다." }
    }
}