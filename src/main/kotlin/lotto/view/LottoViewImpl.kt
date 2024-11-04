import lotto.model.Lotto
class LottoViewImpl: LottoView {
    override fun showTickets(tickets: List<Lotto>) {
        println(formatShowTickets(tickets.size))
        tickets.forEach { println(it.getNumbers()) }
    }
    private fun formatShowTickets(ticketsSize: Int): String{
        return MESSAGE_TICKETS_COUNT.format(ticketsSize)
    }
}