package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.model.LottoResult
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
        outputView.outputLottoResult(lottoResultDetail)
    }
}