import lotto.model.Lotto
class LottoViewImpl: LottoView {
    override fun showTickets(tickets: List<Lotto>) {
        println(formatShowTickets(tickets.size))
        tickets.forEach { println(it.getNumbers()) }
    }

    override fun showCalculatedTickets(calculatedTickets: Map<LottoRank, Int>) {
        println(MESSAGE_SHOW_CALCULATED_TICKETS)
        LottoRank.entries.forEach { rank ->
            if(rank != LottoRank.NONE){
                println(formatCalculatedTickets(rank.matchCount, rank.reward, calculatedTickets[rank] ?: 0))
            }
        }
    }
    private fun formatShowTickets(ticketsSize: Int): String{
        return MESSAGE_TICKETS_COUNT.format(ticketsSize)
    }

    private fun formatCalculatedTickets(matchCount: Int, reward: Int, ticketCount: Int): String{
        val formatReward = NumberFormat.getNumberInstance().format(reward)
        return MESSAGE_CALCULATED_TICKETS.format(matchCount, formatReward, ticketCount)
    }
}