package lotto.model

class LottoAmount(val money: Int) {

    init {
        require(money > 0) { "[ERROR] 로또 구매 금액은 0원 이상이어야 합니다." }
        require(money % 1_000 == 0) { "[ERROR] 로또 구매 금액은 천 원 단위로 입력 가능합니다." }
    }
}