package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.model.LottoRank
import lotto.model.LottoResult
import lotto.model.LottoResultDetail
import lotto.model.toViewData
import lotto.util.ErrorMessage
import lotto.util.validator.InputValidator
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

    fun start() {
        continueAfterException(outputView) { purchaseLotto() }
        continueAfterException(outputView) { showPurchasedLotto() }
        continueAfterException(outputView) { inputWinningNumbers() }
        continueAfterException(outputView) { inputBonusNumber() }
        continueAfterException(outputView) { showLottoResult() }
    }

    private fun purchaseLotto() {
        outputView.outputPurchasePrice()
        purchasePrice = inputView.getPurchasePrice()
    }

    private fun showPurchasedLotto() {
        val lottoGenerator = LottoGenerator(purchasePrice)
        lottoList = lottoGenerator.generate()
        val lottoListViewData = lottoList.toViewData()
        outputView.outputLottoList(lottoListViewData)
    }

    private fun inputWinningNumbers() {
        outputView.outputWinningNumber()
        winningNumbers = inputView.getWinningNumbers()
    }

    private fun inputBonusNumber() {
        outputView.outputBonusNumber()
        bonusNumber = inputView.getBonusNumber()
        require(InputValidator.isBonusNumberUnique(winningNumbers, bonusNumber)) {
            ErrorMessage.LOTTO_NUMBERS_CONTAIN_BONUS_NUMBER.getMessage()
        }
    }

    private fun showLottoResult() {
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

private fun continueAfterException(
    outputView: LottoOutputView,
    block: () -> Unit,
) {
    while (true) {
        try {
            block()
            break
        } catch (e: Exception) {
            val errorMessage = e.localizedMessage
            outputView.printErrorMessage(errorMessage)
        }
    }
}