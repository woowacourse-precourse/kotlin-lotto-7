package lotto.controller

import lotto.model.Rank
import lotto.model.lotto.BonusLotto
import lotto.model.lotto.Lotto
import lotto.model.lotto.LottoTicket
import lotto.model.message.ErrorMessage
import lotto.utils.ValidationUtils
import lotto.view.ErrorView
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val tickets = generateLottoTickets(purchaseAmount)

        OutputView.printLottoTickets(tickets)

        val winningLotto = getWinningNumbers()
        val bonusLotto = getBonusNumber(winningLotto)

        val ranks = tickets.map { calculateMatch(it, winningLotto, bonusLotto) }
        OutputView.printResults(ranks)

        val profitRate = calculateProfitRate(ranks, purchaseAmount)
        OutputView.printProfitRate(profitRate)
    }

    private fun calculateMatch(ticket: LottoTicket, lotto: Lotto, bonusLotto: BonusLotto): Rank {
        val matchCount = ticket.getNumbers().count { it in lotto.getNumbers() }
        val matchBonus = bonusLotto.getBonusNumber() in ticket.getNumbers()
        return Rank.findRank(matchCount, matchBonus)
    }

    private fun generateLottoTickets(purchaseAmount: Int): List<LottoTicket> {
        val ticketCount = purchaseAmount / 1000
        val tickets = List(ticketCount) { LottoTicket.generate() }
        return tickets
    }

    private fun getPurchaseAmount(): Int {
        while (true) {
            try {
                val purchaseAmountInput = InputView.askForPurchaseAmount()
                val purchaseAmount = ValidationUtils.validateNumberInput(purchaseAmountInput)
                ValidationUtils.validatePurchaseAmount(purchaseAmount)
                return purchaseAmount
            } catch (e: IllegalArgumentException) {
                ErrorView.errorMessage(e.message ?: ErrorMessage.DEFAULT_ERROR.message)
            }
        }
    }

    private fun getWinningNumbers(): Lotto {
        while (true) {
            try {
                val winningNumbers = InputView.askWinningNumbers().split(",").map {
                    val trimmed = it.trim()
                    ValidationUtils.validateWinningNumberInput(trimmed)
                }
                return Lotto(winningNumbers)
            } catch (e: IllegalArgumentException) {
                ErrorView.errorMessage(e.message ?: ErrorMessage.DEFAULT_ERROR.message)
            }
        }
    }

    private fun getBonusNumber(lotto: Lotto): BonusLotto {
        while (true) {
            try {
                val bonusInput = InputView.askForBonusNumber()
                val bonusNumber = ValidationUtils.validateNumberInput(bonusInput)
                return BonusLotto(lotto.getNumbers(), bonusNumber)
            } catch (e: IllegalArgumentException) {
                ErrorView.errorMessage(e.message ?: ErrorMessage.DEFAULT_ERROR.message)
            }
        }
    }

    private fun calculateProfitRate(ranks: List<Rank>, purchaseAmount: Int): Double {
        val totalPrize = ranks.sumOf { it.prize }
        return (totalPrize.toDouble() / purchaseAmount.toDouble()) * 100
    }
}
