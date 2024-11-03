package lotto.presenter

import lotto.dto.LottoResult
import lotto.model.LottoResultCalculator
import lotto.dto.WinningTicket
import lotto.model.*
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

    fun calculateLottoResult(lottoBundle: List<Lotto>, winningTicket: WinningTicket): LottoResult {
        val lottoResultCalculator = LottoResultCalculator(winningTicket)
        val result = lottoResultCalculator.countMatchingNumber(lottoBundle)
        val totalReward = lottoResultCalculator.calculateTotalReward()
        val profitRate = lottoResultCalculator.calculateProfitRate(lottoBundle.size, totalReward)

        return LottoResult(result, profitRate)
    }

    fun displayResults(lottoResult: LottoResult) {
        outputView.printWinningStatistics(lottoResult.result)
        outputView.printProfitRate(lottoResult.profitRate)
    }
}