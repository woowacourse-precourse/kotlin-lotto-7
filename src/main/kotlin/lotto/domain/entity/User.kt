package lotto.domain.entity

class User(private val money: Int) {
    private lateinit var lottoTickets: List<Lotto>

    fun buyLottoTickets(lottoTickets: (Int) -> List<Lotto>) {
        val lottoCount = money.div(1000)
        this.lottoTickets = lottoTickets(lottoCount)
    }

    fun getLottoTickets() = lottoTickets.toList()
}