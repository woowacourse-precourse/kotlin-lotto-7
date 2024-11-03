package lotto.model.lotto

class Money(private val money : Int){
    init {
        require(money > 0) { "[ERROR] 금액은 0보다 커야 합니다." }
        require(money % 1000 == 0) { "[ERROR] 금액은 1000원 단위로 입력 가능합니다." }
    }
}