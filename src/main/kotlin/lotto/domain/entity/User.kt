package lotto.domain.entity

class User(private val money: Int) {
    private var lottoTickets: List<Lotto>? = null

    fun buyLottoTickets(lottoTickets: (Int) -> List<Lotto>) {
        val lottoCount = money.div(1000)
        this.lottoTickets = lottoTickets(lottoCount)
    }

    fun getLottoTickets(): List<Lotto> {
        return checkNotNull(lottoTickets) { println("[ERROR] 사용자의 로또 티켓들이 아직 초기화 되지 않았습니다.") }
    }
}