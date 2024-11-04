package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.LottoConstants
import lotto.presenter.LottoPresenter
import lotto.utils.Validator
import lotto.view.interfaces.WinningNumberViewInterface

class WinningNumberView(private val presenter: LottoPresenter) : WinningNumberViewInterface {

  private lateinit var winningNumbers: List<Int>

  override fun requestWinningNumbers() {
    println(LottoConstants.WINNING_NUMBERS_PROMPT)
    val input = Console.readLine()
    val numbers = input.split(",")
      .mapNotNull { it.trim().toIntOrNull() }

    try {
      Validator.validateLottoNumbers(numbers)
      winningNumbers = numbers
      presenter.onWinningNumbersReceived(numbers)
    } catch (e: IllegalArgumentException) {
      requestWinningNumbers()
    }
  }

  override fun requestBonusNumber() {
    println(LottoConstants.BONUS_NUMBER_PROMPT)
    val input = Console.readLine()
    val bonusNumber = input.toIntOrNull()

    try {
      Validator.validateBonusNumber(winningNumbers, bonusNumber)
      presenter.onBonusNumberReceived(bonusNumber!!)
    } catch (e: IllegalArgumentException) {
      requestBonusNumber()
    }
  }

}
