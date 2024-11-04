package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.LottoConstants
import lotto.presenter.LottoPresenter
import lotto.utils.Validator
import lotto.view.interfaces.PurchaseViewInterface

class PurchaseView(private val presenter: LottoPresenter) : PurchaseViewInterface {

  override fun requestPurchaseAmount() {
    println(LottoConstants.PURCHASE_AMOUNT_PROMPT)
    val input = Console.readLine()
    val amount = input.toIntOrNull()

    try {
      Validator.validatePurchaseAmount(amount)
      presenter.onPurchaseAmountReceived(amount!!)
    } catch (e: IllegalArgumentException) {
      println("[ERROR] ${LottoConstants.ERROR_INVALID_PURCHASE_AMOUNT}")
      requestPurchaseAmount()
    }
  }
}
