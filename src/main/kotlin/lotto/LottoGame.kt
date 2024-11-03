package lotto

import lotto.view.LottoInput
import lotto.view.LottoOutput

class LottoGame {
    private val lottoInput = LottoInput()
    private val lottoOutput = LottoOutput()
    private val validator = Validator()
    private val lottoMachine = LottoMachine()

    fun startLotto() {
        val purchasePrice = checkValidatedPurchasePrice()

        val lottoTicketCount = purchasePrice / 1000
        lottoOutput.printTicketCount(lottoTicketCount)

        val lottoTickets = lottoMachine.generateLottoTickets(lottoTicketCount)
        lottoOutput.printLottoTickets(lottoTickets)

        val winningNumbers = checkValidatedWinningNumbers()

        val bonusNumber = checkValidatedBonusNumber(winningNumbers)
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
}