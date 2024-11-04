package lotto.view

import lotto.LottoRank
import lotto.presenter.ResultPresenter
import lotto.view.interfaces.ResultViewInterface
import lotto.constants.ResultConstants

class ResultView : ResultViewInterface {
  private lateinit var presenter: ResultPresenter

  override fun displayResults(resultMap: Map<LottoRank, Int>) {
    println(ResultConstants.RESULT_HEADER)
    println(ResultConstants.RESULT_DIVIDER)
    LottoRank.values().filter { it != LottoRank.NONE }.sortedBy { it.matchCount }.forEach { rank ->
      val count = resultMap.getOrDefault(rank, 0)
      println("${rank.description} (${String.format("%,d", rank.prize)}원) - ${count}개")
    }
  }

  override fun displayYield(yield: Double) {
    println(ResultConstants.YIELD_MESSAGE.format(yield))
  }

  override fun setPresenter(presenter: ResultPresenter) {
    this.presenter = presenter
  }
}
