package model

import utils.InputUtils
import view.OutputView
import kotlin.math.log

class LottoTickets(money: Int) {
    val ticketCounts = money / InputUtils.MONEY_UNIT
    val lottoTickets = mutableListOf<Lotto>()

    init {
        repeat(ticketCounts) {
            val ticket = LottoMaker.makeLotto()
            lottoTickets.add(ticket)
            OutputView.printTickets(ticket.getLottoTicket())
        }
    }
}