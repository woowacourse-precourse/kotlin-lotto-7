package lotto.presenter


import lotto.model.LottoTicket
import lotto.util.ConstantsUtil.TICKET_PRICE
import lotto.util.ValidatorUtil.validateTicketsPrice
import lotto.view.LottoView

class LottoPresenter(
    private val view: LottoView,
    private val lottoTicket: LottoTicket
) {
    fun onPurchaseAmountEntered(price: Int) {
        validateTicketsPrice(price)
        val ticketCount = price / TICKET_PRICE
        val tickets = lottoTicket.generateTickets(price)
        view.showTickets(tickets)
    }
}