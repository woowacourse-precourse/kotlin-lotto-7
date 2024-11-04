package lotto.view.interfaces

import lotto.presenter.PurchasePresenter

interface PurchaseViewInterface {
  fun requestPurchaseAmount()
  fun setPresenter(presenter: PurchasePresenter)
}
