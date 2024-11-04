package lotto.presenter

import lotto.model.LottoRank
import lotto.model.LottoTicket
import lotto.util.ConstantsUtil.TICKET_PRICE
import lotto.util.ValidatorUtil.validateTicketsPrice
import lotto.util.ValidatorUtil.validateUniqueWinningNumbers
import lotto.util.ValidatorUtil.validateWinningNumbersRange
import lotto.util.ValidatorUtil.validateWinningNumbersSize
import lotto.view.LottoView

class LottoPresenter(
    private val view: LottoView,
    private val lottoTicket: LottoTicket
) {
    fun processLottoTickets(price: Int) {
        validateTicketsPrice(price)
        val ticketCount = price / TICKET_PRICE
        val tickets = lottoTicket.generateTickets(ticketCount)
        view.showTickets(tickets)
    }

    fun processWinningNumbers(winningNumbers: List<Int>, bonusNumber: Int, price: Int) {
        validateUniqueWinningNumbers(winningNumbers)
        validateWinningNumbersSize(winningNumbers.size)
        validateWinningNumbersRange(winningNumbers)

        val results = lottoTicket.calculateTickets(winningNumbers, bonusNumber)
        view.showCalculatedTickets(results)

        showYieldCalculation(price, results)
    }

    private fun showYieldCalculation(purchasePrice: Int, results: Map<LottoRank, Int>) {
        val totalWinningAmount = calculateTotalWinningPrice(results)
        val returnRate = calculateReturnRate(purchasePrice, totalWinningAmount)
        view.showReturnRate(returnRate)
    }

    private fun calculateTotalWinningPrice(results: Map<LottoRank, Int>): Int {
        return results.entries.sumOf { (rank, count) -> rank.reward * count }
    }

    private fun calculateReturnRate(totalPrice: Int, totalWinningPrice: Int): Double {
        return (totalWinningPrice.toDouble() / totalPrice) * 100
    }

}