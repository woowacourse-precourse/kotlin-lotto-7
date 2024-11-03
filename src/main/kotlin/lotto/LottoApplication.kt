package lotto

import lotto.model.Lotto
import lotto.model.LottoResultCalculator
import lotto.presenter.InputPresenter
import lotto.presenter.LottoPresenter
import lotto.view.InputViewImpl
import lotto.view.OutputViewImpl

class LottoApplication {

    fun run() {
        val inputView = InputViewImpl()
        val outputView = OutputViewImpl()
        val inputPresenter = InputPresenter(inputView, outputView)
        val lottoPresenter = LottoPresenter(inputPresenter, outputView)

        val lottoBundle =lottoPresenter.purchaseLotto()
        val winningTicket = lottoPresenter.getWinningTicket()

        val lottoResultCalculator = LottoResultCalculator(winningTicket)

        val result = lottoResultCalculator.countMatchingNumber(lottoBundle)
        outputView.printWinningStatistics(result)
        val totalReward = lottoResultCalculator.calculateTotalReward()
        val profitRate = lottoResultCalculator.calculateProfitRate(lottoBundle.size, totalReward)
        outputView.printProfitRate(profitRate)
    }
}