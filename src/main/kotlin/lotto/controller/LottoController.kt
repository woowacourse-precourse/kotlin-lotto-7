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

    private val rankCounts = mutableMapOf<LottoRank, Int>()

    fun start() {
        val purchaseAmount = getVaildPurchaseAmount()
        val purchaseCount = purchaseAmount / LOTTO_PRICE
        val purchaseLottoTickets =  List(purchaseCount) { LottoTicket.generate() }

        outputView.showPurchasedLottoCount(purchaseCount, purchaseLottoTickets)

        val winningNumbers = getVaildWinningNumbers()
        val bonusNumber = getValidBonusNumber(winningNumbers)

        rankCounts.putAll(lotto.calculateLottoResults(purchaseLottoTickets, bonusNumber))
        outputView.showLottoResult(rankCounts)

        val totalReturnRate = lotto.calculateTotalReturnRate(rankCounts, purchaseAmount)
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