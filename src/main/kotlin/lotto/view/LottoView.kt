package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank

interface LottoView {
    fun showTickets(tickets: List<Lotto>)
    fun showCalculatedTickets(calculatedTickets: Map<LottoRank, Int>)
    fun getTicketsPrice(): Int
    fun getWinningNumbers(): List<Int>
    fun getBonusNumber(): Int
}