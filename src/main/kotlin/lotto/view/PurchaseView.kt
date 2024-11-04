package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.LottoConstants
import lotto.presenter.LottoPresenter
import lotto.view.interfaces.PurchaseViewInterface

class PurchaseView(private val presenter: LottoPresenter) : PurchaseViewInterface {

  override fun requestPurchaseAmount() {
    println(LottoConstants.PURCHASE_AMOUNT_PROMPT)
    val amount = Console.readLine().toIntOrNull()

    if (amount != null && amount % LottoConstants.LOTTO_PRICE == 0) {
      presenter.onPurchaseAmountReceived(amount)
      return
    }

    showErrorMessage(LottoConstants.ERROR_INVALID_PURCHASE_AMOUNT)
    requestPurchaseAmount()
  }

  override fun showErrorMessage(message: String) {
    ErrorMessageView.showErrorMessage(message)
  }
}
