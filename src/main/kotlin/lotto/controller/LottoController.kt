package lotto.controller

import lotto.model.InputValidator
import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoTicket
import lotto.utils.Constants.LOTTO_PRICE
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    val inputView = InputView()
    val outputView = OutputView()

    lateinit var lotto: Lotto

    private val lottoRankCounts = mutableMapOf<LottoRank, Int>()

    fun start() {
        val purchaseAmount = getVaildPurchaseAmount()
        val purchaseCount = purchaseAmount / LOTTO_PRICE
        val lottoTickets =  List(purchaseCount) { LottoTicket.generate() }

        outputView.showPurchaseLottoDetails(purchaseCount, lottoTickets)

        val winningNumbers = getVaildWinningNumbers()
        val bonusNumber = getValidBonusNumber(winningNumbers)

        lottoRankCounts.putAll(lotto.calculateLottoResults(lottoTickets, bonusNumber))
        outputView.showLottoResult(lottoRankCounts)

        val totalReturnRate = lotto.calculateTotalReturnRate(lottoRankCounts, purchaseAmount)
        outputView.showTotalReturnRate(totalReturnRate)
    }

    private fun getVaildPurchaseAmount(): Int {
        while (true) {
            try {
                val purchaseAmount = inputView.getPurchaseAmount()
                InputValidator.validatePurchaseAmount(purchaseAmount)
                return purchaseAmount!!
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getVaildWinningNumbers(): List<Int> {
        while (true) {
            try {
                val winningNumbers = inputView.getWinningNumbers()
                lotto = Lotto(winningNumbers)
                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                val bonusNumber = inputView.getBonusNumber()
                InputValidator.validateBonusNumber(bonusNumber, winningNumbers)
                return bonusNumber!!
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}