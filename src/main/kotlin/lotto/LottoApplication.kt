package lotto

import lotto.presenter.InputPresenter
import lotto.presenter.LottoPresenter
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun run() {
        val inputPresenter = createInputPresenter()
        val lottoPresenter = createLottoPresenter(inputPresenter)

        val lottoBundle = lottoPresenter.purchaseLotto()
        val winningTicket = lottoPresenter.getWinningTicket()

        val lottoResult = lottoPresenter.calculateLottoResult(lottoBundle, winningTicket)

        lottoPresenter.displayResults(lottoResult)
    }

    private fun createInputPresenter(): InputPresenter {
        return InputPresenter(inputView, outputView)
    }

    private fun createLottoPresenter(inputPresenter: InputPresenter): LottoPresenter {
        return LottoPresenter(inputPresenter, outputView)
    }
}