package lotto

import lotto.model.LottoModel
import lotto.presenter.PurchasePresenter
import lotto.presenter.ResultPresenter
import lotto.presenter.WinningNumberPresenter
import lotto.view.PurchaseView
import lotto.view.ResultView
import lotto.view.WinningNumberView

fun main() {
  // 모델 생성
  val lottoModel = LottoModel()

  // 뷰 생성
  val purchaseView = PurchaseView()
  val winningNumberView = WinningNumberView()
  val resultView = ResultView()

  // 프레젠터 생성
  val purchasePresenter = PurchasePresenter(purchaseView, winningNumberView, lottoModel)
  val winningNumberPresenter = WinningNumberPresenter(winningNumberView, lottoModel, resultView)
  val resultPresenter = ResultPresenter(resultView, lottoModel)

  // 각 뷰에 프레젠터 연결
  purchaseView.setPresenter(purchasePresenter)
  winningNumberView.setPresenter(winningNumberPresenter)
  resultView.setPresenter(resultPresenter)

  // 프로그램 시작
  purchasePresenter.startPurchase()
}

