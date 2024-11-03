package lotto

import lotto.view.LottoInput
import lotto.view.LottoOutput

class LottoGame {
    private val lottoInput = LottoInput()
    private val lottoOutput = LottoOutput()
    private val validator = Validator()
    private val lottoMachine = LottoMachine()
    private val lottoResult = LottoResult()

    fun startLotto() {
        val purchasePrice = checkValidatedPurchasePrice()
        val lottoTicketCount = purchasePrice / 1000
        lottoOutput.printTicketCount(lottoTicketCount)

        val lottoTickets = lottoMachine.generateLottoTickets(lottoTicketCount)
        lottoOutput.printLottoTickets(lottoTickets)

        val winningNumbers = checkValidatedWinningNumbers()
        val bonusNumber = checkValidatedBonusNumber(winningNumbers)

        calculateResults(lottoTickets, winningNumbers, bonusNumber)
        lottoOutput.printResult(lottoResult.getResults())
        calculateProfitRate(lottoResult.getResults(), purchasePrice)
    }

    private fun checkValidatedPurchasePrice(): Int {
        return generateSequence {
            val input = lottoInput.getPurchasePrice()
            validator.validatePurchasePrice(input)
        }.firstNotNullOfOrNull { it } ?: checkValidatedPurchasePrice()
    }

    private fun checkValidatedWinningNumbers(): List<Int> {
        return generateSequence {
            val input = lottoInput.getWinningNumbers()
            validator.validateWinningNumbers(input)
        }.firstNotNullOfOrNull { it } ?: checkValidatedWinningNumbers()
    }

    private fun checkValidatedBonusNumber(winningNumbers: List<Int>): Int {
        return generateSequence {
            val input = lottoInput.getBonusNumber()
            validator.validateBonusNumber(input, winningNumbers)
        }.firstNotNullOfOrNull { it } ?: checkValidatedBonusNumber(winningNumbers)
    }

    private fun calculateResults(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int) {
        tickets.forEach { ticket ->
            val matchCount = ticket.countMatchingNumbers(winningNumbers)
            val isBonusMatched = ticket.containsBonusNumber(bonusNumber)
            val rank = Rank.from(matchCount, isBonusMatched)
            lottoResult.addResult(rank)
        }
    }

    private fun calculateProfitRate(results: Map<Rank, Int>, purchasePrice: Int) {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize * count }
        val profitRate = (totalPrize.toDouble() / purchasePrice) * 100
        val roundedProfitRate = String.format("%.1f", profitRate)
        lottoOutput.printProfitRate(roundedProfitRate)
    }
}