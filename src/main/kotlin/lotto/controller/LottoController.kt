package lotto.controller

import lotto.model.Rank
import lotto.model.lotto.BonusLotto
import lotto.model.lotto.Lotto
import lotto.model.lotto.LottoTicket
import lotto.model.message.ErrorMessage
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val purchaseAmount = getPrice()
        val tickets = generateLottoTickets(purchaseAmount)

        OutputView.printLottoTickets(tickets)

        val winningLotto = getWinningNumbers()
        val bonusLotto = getAllLottoNumbers(winningLotto)

        val ranks = tickets.map { calculateMatch(it, winningLotto, bonusLotto) }
        OutputView.printResults(ranks)
    }

    private fun calculateMatch(ticket: LottoTicket, lotto: Lotto, bonusLotto: BonusLotto): Rank {
        val matchCount = ticket.getNumbers().count { it in lotto.getNumbers() }
        val matchBonus = bonusLotto.getBonusNumber() in ticket.getNumbers()
        return Rank.findRank(matchCount, matchBonus)
    }

    private fun generateLottoTickets(purchaseAmount: Int): List<LottoTicket> {
        require(purchaseAmount % 1000 == 0) { ErrorMessage.PURCHASE_PRICE_1000.message }
        val ticketCount = purchaseAmount / 1000

        val tickets = List(ticketCount) { LottoTicket.generate() }

        return tickets
    }

    private fun getPrice(): Int {
        val purchasePrice = InputView.askForPrice().toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.message)
        return purchasePrice
    }

    private fun getWinningNumbers(): Lotto {
        val purchasePrice = InputView.askWinningNumbers().split(",").map {
            val trimmed = it.trim()
            require(trimmed.isNotEmpty()) { ErrorMessage.INPUT_WINNING_EMPTY.message }
            trimmed.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.INPUT_WINNING_ONLY_NUMBERS.message)
        }
        return Lotto(purchasePrice)
    }

    private fun getAllLottoNumbers(lotto: Lotto): BonusLotto {
        val bonusNumber = InputView.askForBonusNumber().toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.message)
        return BonusLotto(lotto.getNumbers(), bonusNumber)
    }
}