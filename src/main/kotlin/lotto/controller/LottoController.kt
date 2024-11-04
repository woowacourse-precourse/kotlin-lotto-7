package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.model.LottoRank
import lotto.model.LottoResult
import lotto.model.LottoResultDetail
import lotto.model.toViewData
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

class LottoController(
    private val inputView: LottoInputView,
    private val outputView: LottoOutputView,
) {
    private var purchasePrice = 0
    private var lottoList = listOf<Lotto>()
    private var winningNumbers = listOf<Int>()
    private var bonusNumber = 0
    private val printableRankList = mutableListOf<String>()
    private val winningRankCountList = mutableListOf<Int>()

    fun purchaseLotto() {
        outputView.outputPurchasePrice()
        purchasePrice = inputView.getPurchasePrice()
    }

    fun showPurchasedLotto() {
        val lottoGenerator = LottoGenerator(purchasePrice)
        lottoList = lottoGenerator.generate()
        val lottoListViewData = lottoList.toViewData()
        outputView.outputLottoList(lottoListViewData)
    }

    fun inputWinningNumbers() {
        outputView.outputWinningNumber()
        winningNumbers = inputView.getWinningNumbers()
    }

    fun inputBonusNumber() {
        outputView.outputBonusNumber()
        bonusNumber = inputView.getBonusNumber()
    }

    fun showLottoResult() {
        val lottoResult = LottoResult(lottoList, winningNumbers, bonusNumber)
        val lottoResultDetail = lottoResult.getResult()
        val roundedRateOfReturn = lottoResultDetail.roundedRateOfReturnText

        calculateRankList(lottoResultDetail)

        outputView.outputLottoResult(
            printableRankList = printableRankList,
            winningRankCountList = winningRankCountList,
            rateOfReturn = roundedRateOfReturn
        )
    }

    private fun calculateRankList(lottoResultDetail: LottoResultDetail) {
        LottoRank.entries.forEach { rank ->
            if (rank != LottoRank.NOTHING) {
                val rankCount = lottoResultDetail.winningRankList.count { it == rank }
                winningRankCountList.add(rankCount)
                printableRankList.add(rank.print())
            }
        }
    }
}