package lotto.view.interfaces

import lotto.LottoRank
import lotto.presenter.ResultPresenter

interface ResultViewInterface {
  fun displayResults(resultMap: Map<LottoRank, Int>)
  fun displayYield(yield: Double)
  fun setPresenter(presenter: ResultPresenter)
}
