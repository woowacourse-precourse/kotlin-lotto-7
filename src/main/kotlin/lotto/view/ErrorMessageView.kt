package lotto.view

import lotto.view.interfaces.LottoViewInterface

object ErrorMessageView : LottoViewInterface {
  override fun showErrorMessage(message: String) {
    println(message)
  }
}
