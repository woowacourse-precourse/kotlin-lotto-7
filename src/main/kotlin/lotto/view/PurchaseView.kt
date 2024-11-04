package lotto.view

import lotto.presenter.PurchasePresenter
import lotto.constants.LottoConstants
import lotto.view.interfaces.PurchaseViewInterface
import camp.nextstep.edu.missionutils.Console

class PurchaseView : PurchaseViewInterface {
  private lateinit var presenter: PurchasePresenter

  override fun requestPurchaseAmount() {
    println(LottoConstants.PURCHASE_AMOUNT_PROMPT)
    val input = Console.readLine()
    val amount = input.toIntOrNull()
    presenter.onPurchaseAmountReceived(amount)
  }

  override fun setPresenter(presenter: PurchasePresenter) {
    this.presenter = presenter
  }
}
