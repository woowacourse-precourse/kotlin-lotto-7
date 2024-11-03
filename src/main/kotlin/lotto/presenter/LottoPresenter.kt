package lotto.presenter

import lotto.model.Lotto
import lotto.model.LottoSeller
import lotto.model.LottoWinning
import lotto.model.WinningTicket
import lotto.view.OutputView

class LottoPresenter(
    private val inputPresenter: InputPresenter,
    private val outputView: OutputView
) {

    fun purchaseLotto(): List<Lotto> {
        val amount = inputPresenter.onPurchaseAmountInput()
        val lottoSeller = LottoSeller(amount)
        val lottoBundle = lottoSeller.sell()
        outputView.printPurchaseSummary(lottoBundle)
        return lottoBundle
    }

    fun getWinningTicket(): WinningTicket {
        val winningNumbers = inputPresenter.onWinningNumbersInput()
        val winningLotto = Lotto(winningNumbers)
        val bonusNumber = inputPresenter.onBonusNumberInput()
        return WinningTicket(winningLotto, bonusNumber)
    }

    fun displayResults(result: Map<LottoWinning, Int>, profitRate: Double) {
        outputView.printWinningStatistics(result)
        outputView.printProfitRate(profitRate)
    }
}