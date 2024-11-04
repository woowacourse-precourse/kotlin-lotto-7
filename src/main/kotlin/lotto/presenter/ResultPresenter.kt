package lotto.presenter

import lotto.model.LottoModel
import lotto.utils.LottoResultCalculator
import lotto.view.interfaces.ResultViewInterface

class ResultPresenter(
  private val resultView: ResultViewInterface,
  private val lottoModel: LottoModel
) {
  fun calculateAndDisplayResults() {
    val resultMap = LottoResultCalculator.calculateResults(
      lottoModel.generatedLottos,
      lottoModel.winningNumbers,
      lottoModel.bonusNumber
    )
    resultView.displayResults(resultMap)

    val yield = LottoResultCalculator.calculateYield(resultMap, lottoModel.purchaseAmount)
    resultView.displayYield(yield)
  }
}
