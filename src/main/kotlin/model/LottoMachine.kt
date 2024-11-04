package model

import view.InputView

object LottoMachine {
    private val input = InputView

    fun runMachine() {
        getLotto()
    }
    fun getLotto() {
        val money = input.getMoney()
        val lottoTickets = LottoTickets(money)

    }
}