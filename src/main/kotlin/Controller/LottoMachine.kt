package Controller

import model.LottoTickets
import view.InputView
import view.OutputView

object LottoMachine {

    fun runMachine() {
        getLotto()
    }
    fun getLotto() {
        val money = InputView.getMoney()

        val lottoTickets = LottoTickets(money)
        OutputView.printTicketCounts(lottoTickets.ticketCounts)

    }
}