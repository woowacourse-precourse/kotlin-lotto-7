package lotto

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

        val lottoBundle = lottoPresenter.purchaseLotto()
        val winningTicket = lottoPresenter.getWinningTicket()

        val lottoResult = lottoPresenter.calculateLottoResult(lottoBundle, winningTicket)

        lottoPresenter.displayResults(lottoResult)
    }
}