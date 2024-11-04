package lotto.view.interfaces

import lotto.presenter.WinningNumberPresenter

interface WinningNumberViewInterface {
  fun requestWinningNumbers()
  fun requestBonusNumber()
  fun setPresenter(presenter: WinningNumberPresenter)
}
