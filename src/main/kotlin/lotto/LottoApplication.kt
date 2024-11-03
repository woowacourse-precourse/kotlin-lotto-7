package lotto

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
        val totalReward = lottoResultCalculator.calculateTotalReward()
        val profitRate = lottoResultCalculator.calculateProfitRate(lottoBundle.size, totalReward)

        lottoPresenter.displayResults(result, profitRate)
    }
}