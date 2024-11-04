package lotto.controller

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun run() {
        val purchase = getPurchase()
        val lottoPurchaseCount = purchase.getLottoCount()
        val lottos = getLottos(lottoPurchaseCount)

        outputLottosProcess(lottoPurchaseCount, lottos)

        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber()

        val lottoResult = LottoResult(
            lottos = lottos,
            winningNumbers = winningNumbers,
            bonusNumber = bonusNumber,
        )

        val rankCount = lottoResult.getRankCount()
        val totalPrize = lottoResult.getTotalPrize()

        outputView.printStatisticsMessages()
        outputView.printLottoRankResult(rankCount)

        val revenue = Revenue(purchase.amount, totalPrize)
        val revenueRate = revenue.getRevenueRate()
        outputView.printProfitRate(revenueRate)
    }

    private fun getPurchase(): Purchase {
        while (true) {
            try {
                val inputAmount = inputView.inputPurchasePrice()
                return Purchase(inputAmount)
            } catch (exception: IllegalArgumentException) {
                println("$ERROR ${exception.message}")
            }
        }
    }

    private fun getLottos(purchaseCount: Int) = Lottos(purchaseCount).lottos

    private fun outputLottosProcess(lottoPurchaseCount: Int, lottos: List<Lotto>) {
        outputView.printPurchaseCountMessage(lottoPurchaseCount)
        lottos.forEach { lotto ->
            outputView.printLottoNumber(lotto.getNumbers())
        }
    }

    private fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                val inputWinningNumbers = inputView.inputWinningNumbers()
                val winningNumbers = WinningNumbers(inputWinningNumbers)
                return winningNumbers.winningNumbers
            } catch (exception: IllegalArgumentException) {
                println("$ERROR ${exception.message}")
            }
        }
    }

    private fun getBonusNumber(): Int {
        while (true) {
            try {
                val inputBonusNumber = inputView.inputBonusNumber()
                val bonus = Bonus(inputBonusNumber)
                return bonus.number
            } catch (exception: IllegalArgumentException) {
                println("$ERROR ${exception.message}")
            }
        }
    }

    companion object {
        private const val ERROR = "[ERROR]"
    }
}
