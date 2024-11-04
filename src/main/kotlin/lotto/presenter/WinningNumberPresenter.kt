package lotto.presenter

import lotto.model.LottoModel
import lotto.utils.Validator
import lotto.view.interfaces.WinningNumberViewInterface
import lotto.view.interfaces.ResultViewInterface

class WinningNumberPresenter(
  private val winningNumberView: WinningNumberViewInterface,
  private val lottoModel: LottoModel,
  private val resultView: ResultViewInterface,
) {

  private val resultPresenter = ResultPresenter(resultView, lottoModel)


  fun onWinningNumbersReceived(winningNumbers: List<Int>) {
    try {
      Validator.validateLottoNumbers(winningNumbers)
      lottoModel.winningNumbers = winningNumbers
      winningNumberView.requestBonusNumber()
    } catch (e: IllegalArgumentException) {
      winningNumberView.requestWinningNumbers()
    }
  }

  fun onBonusNumberReceived(bonusNumber: Int?) {
    try {
      Validator.validateBonusNumber(lottoModel.winningNumbers, bonusNumber)
      lottoModel.bonusNumber = bonusNumber

      resultPresenter.calculateAndDisplayResults()
    } catch (e: IllegalArgumentException) {
      winningNumberView.requestBonusNumber()
    }
  }
}
