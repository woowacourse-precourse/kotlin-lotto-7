package lotto.presenter

import lotto.dto.LottoBundle
import lotto.dto.LottoResult
import lotto.model.LottoResultCalculator
import lotto.dto.WinningTicket
import lotto.model.*
import lotto.view.OutputView

class LottoPresenter(
    private val inputPresenter: InputPresenter,
    private val outputView: OutputView
) {

    fun purchaseLotto(): LottoBundle {
        val amount = inputPresenter.onPurchaseAmountInput()
        val lottoSeller = LottoSeller(amount)
        val items = lottoSeller.sell()
        val lottoBundle = LottoBundle(items)
        outputView.printPurchaseSummary(lottoBundle.lottos)

        return lottoBundle
    }

    fun getWinningTicket(): WinningTicket {
        val winningNumbers = inputPresenter.onWinningNumbersInput()
        val bonusNumber = inputPresenter.onBonusNumberInput(winningNumbers)
        val winningLotto = Lotto(winningNumbers)

        return WinningTicket(winningLotto, bonusNumber)
    }

    fun calculateLottoResult(lottoBundle: LottoBundle, winningTicket: WinningTicket): LottoResult {
        val lottoResultCalculator = LottoResultCalculator(winningTicket)
        val result = lottoResultCalculator.countMatchingNumber(lottoBundle.lottos)
        val totalReward = lottoResultCalculator.calculateTotalReward()
        val profitRate = lottoResultCalculator.calculateProfitRate(lottoBundle.lottos.size, totalReward)

        return LottoResult(result, profitRate)
    }

    fun displayResults(lottoResult: LottoResult) {
        outputView.printWinningStatistics(lottoResult.result)
        outputView.printProfitRate(lottoResult.profitRate)
    }
}