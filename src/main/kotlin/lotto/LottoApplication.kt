package lotto

import lotto.model.Lotto
import lotto.model.LottoResultCalculator
import lotto.model.LottoSeller
import lotto.presenter.InputPresenter
import lotto.view.InputViewImpl
import lotto.view.OutputViewImpl

class LottoApplication {

    fun run() {
        val inputView = InputViewImpl()
        val outputView = OutputViewImpl()
        val inputPresenter = InputPresenter(inputView, outputView)

        val amount = inputPresenter.onPurchaseAmountInput()

        val lottoSeller = LottoSeller(amount)
        val lottoBundle = lottoSeller.sell()
        outputView.printPurchaseSummary(lottoBundle)

        val winningNumbers = inputPresenter.onWinningNumbersInput()
        val winningLotto = Lotto(winningNumbers)

        val bonusNumber = inputPresenter.onBonusNumberInput()

        val lottoResultCalculator = LottoResultCalculator(winningLotto, bonusNumber)
        val result = lottoResultCalculator.countMatchingNumber(lottoBundle)
        outputView.printWinningStatistics(result)
        val totalReward = lottoResultCalculator.calculateTotalReward()
        val profitRate = lottoResultCalculator.calculateProfitRate(lottoBundle.size, totalReward)
        outputView.printProfitRate(profitRate)
    }
}