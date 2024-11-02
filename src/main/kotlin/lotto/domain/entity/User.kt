package lotto.domain.entity

import camp.nextstep.edu.missionutils.Randoms

class User(private val money: Int) {
    private lateinit var lottoTickets: List<Lotto>

    init {
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

    fun getLottoTickets() = lottoTickets.toList()
}