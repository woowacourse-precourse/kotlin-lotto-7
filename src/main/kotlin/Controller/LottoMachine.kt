package Controller

import model.LottoTickets
import view.InputView
import view.OutputView

object LottoMachine {

    fun runMachine() {
        getLotto()
        getWinNumbers()
    }

    private fun getLotto() {
        val money = InputView.getMoney()
        OutputView.newLine()

        val lottoTickets = LottoTickets(money)

        OutputView.printTicketCounts(lottoTickets.ticketCounts)
        OutputView.printTickets(lottoTickets.lottoTickets)
        OutputView.newLine()
    }

    private fun getWinNumbers() {
        val winNumbers = InputView.getWinNumbers()
    }
}