package model

import utils.InputUtils

class LottoTickets(money: Int) {
    val ticketCounts = money / InputUtils.MONEY_UNIT
}