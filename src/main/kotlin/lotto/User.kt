package lotto

class User(private val money: Int) {
    lateinit var lottoTickets: List<Lotto>

    init {
        validateMoney()
    }

    private fun validateMoney() {
        require(money.rem(1000) == 0) { "[ERROR] 돈은 1000원으로 나누어 떨어져야 합니다." }
        require(money >= 0) { "[ERROR] 돈은 0보다 같거나 커야 합니다." }
    }
}