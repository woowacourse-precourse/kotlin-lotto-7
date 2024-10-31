package lotto

import camp.nextstep.edu.missionutils.Randoms

class User(private val money: Int) {
    private lateinit var lottoTickets: List<Lotto>

    init {
        validateMoney()
        buyLottoTickets()
    }

    private fun buyLottoTickets() {
        val lottoCount = money.div(1000)
        lottoTickets = List(lottoCount) { createLotto() }
    }

    private fun createLotto(): Lotto {
        val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(lottoNumbers)
    }

    private fun validateMoney() {
        require(money.rem(1000) == 0) { "[ERROR] 돈은 1000원으로 나누어 떨어져야 합니다." }
        require(money >= 0) { "[ERROR] 돈은 0보다 같거나 커야 합니다." }
    }

    fun getLottoTickets() = lottoTickets.toList()
}