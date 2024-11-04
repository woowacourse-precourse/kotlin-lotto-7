package model

import utils.InputUtils

class LottoTickets(money: Int) {
    val tickets = money / InputUtils.MONEY_UNIT
}