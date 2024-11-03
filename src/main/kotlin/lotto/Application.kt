package lotto

import lotto.input.InputManager


fun main() {
    val lottoGame = LottoGame()

    val payment: Int = InputManager.requestPayment()
    lottoGame.buyTickets(payment)
    lottoGame.printTicketList()

    val winningNumbers: List<Int> = InputManager.requestWinningNumbers()
    val bonusNumber: Int = InputManager.requestBonusNumber(winningNumbers)
    lottoGame.initialize(winningNumbers, bonusNumber)
    lottoGame.printWinningResults()
    lottoGame.printRatioOfProfit()
}
