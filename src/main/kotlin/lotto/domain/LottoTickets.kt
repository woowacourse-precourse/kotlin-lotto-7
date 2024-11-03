package lotto.domain

class LottoTickets(val tickets: List<Lotto>) {
    fun size(): Int = tickets.size
}