package lotto.controller

import lotto.model.LottoCalculator
import lotto.model.LottoMachine
import lotto.model.LottoResult
import lotto.util.InputValidator
import lotto.view.LottoInput
import lotto.view.LottoOutput

class LottoController {
    private val lottoInput = LottoInput()
    private val lottoOutput = LottoOutput()
    private val lottoMachine = LottoMachine()
    private val validator = InputValidator()
    private val lottoResult = LottoResult()
    private val lottoCalculator = LottoCalculator()

    fun startLotto() {
        val purchasePrice = getValidatedPurchasePrice()

        val lottoTicketCount = purchasePrice / 1000
        lottoOutput.printTicketCount(lottoTicketCount)

        val lottoTickets = lottoMachine.generateLottoTickets(lottoTicketCount)
        lottoOutput.printLottoTickets(lottoTickets)

        val winningNumbers = getValidatedWinningNumbers()
        val bonusNumber = getValidatedBonusNumber(winningNumbers)

        val results = lottoResult.getRankedTickets(lottoTickets, winningNumbers, bonusNumber)
        lottoOutput.printResult(results)

        val profitRate = lottoCalculator.calculateProfitRate(results, purchasePrice)
        lottoOutput.printProfitRate(profitRate)
    }

    private fun getValidatedPurchasePrice(): Int {
        return generateSequence {
            val input = lottoInput.getPurchasePrice()
            validator.validatePurchasePrice(input)
        }.firstNotNullOfOrNull { it } ?: getValidatedPurchasePrice()
    }

    private fun getValidatedWinningNumbers(): List<Int> {
        return generateSequence {
            val input = lottoInput.getWinningNumbers()
            validator.validateWinningNumbers(input)
        }.firstNotNullOfOrNull { it } ?: getValidatedWinningNumbers()
    }

    private fun getValidatedBonusNumber(winningNumbers: List<Int>): Int {
        return generateSequence {
            val input = lottoInput.getBonusNumber()
            validator.validateBonusNumber(input, winningNumbers)
        }.firstNotNullOfOrNull { it } ?: getValidatedBonusNumber(winningNumbers)
    }
}