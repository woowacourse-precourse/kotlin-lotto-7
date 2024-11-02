package lotto

class LottoSeller(private val money: Int) {
    init {
        require(money >= 1000) { "[ERROR] 로또 구매 금액은 최소 1000원 이상이어야 합니다." }
        require(money % 1000 == 0) { "[ERROR] 로또 구매 금액은 1000원 단위여야 합니다." }
    }

    val lottoCount: Int
        get() = money / 1000

    fun sell(): List<Lotto> {
        return (1..lottoCount).map { LottoMachine.generate() }
    }
}