package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.LottoConstants
import lotto.presenter.WinningNumberPresenter
import lotto.view.interfaces.WinningNumberViewInterface

class WinningNumberView : WinningNumberViewInterface {
  private lateinit var presenter: WinningNumberPresenter

  override fun requestWinningNumbers() {
    println(LottoConstants.WINNING_NUMBERS_PROMPT)
    val input = Console.readLine()
    val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
    presenter.onWinningNumbersReceived(numbers)
  }

  override fun requestBonusNumber() {
    println(LottoConstants.BONUS_NUMBER_PROMPT)
    val input = Console.readLine()
    val bonusNumber = input.toIntOrNull()
    presenter.onBonusNumberReceived(bonusNumber)
  }

  override fun setPresenter(presenter: WinningNumberPresenter) {
    this.presenter = presenter
  }
}
