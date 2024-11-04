package model

import utils.InputUtils
import kotlin.math.log

class LottoTickets(money: Int) {
    val ticketCounts = money / InputUtils.MONEY_UNIT
    val lottoTickets = mutableListOf<List<Int>>()

    init {
        repeat(ticketCounts) {
            val ticket = LottoMaker.makeLotto()
            lottoTickets.add(ticket)
        }
    }
}