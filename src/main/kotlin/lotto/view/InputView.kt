package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputValidator

class InputView {
    private val inputValidator = InputValidator()

    fun inputPurchaseAmount(): String {
        val purchaseAmount = Console.readLine()
        return purchaseAmount
    }

    fun inputWinningNumbers(): List<Int?> {
        val winningNumbers = Console.readLine()
        val parsedWinningNumbers = winningNumbers.split(",").map { it.trim().toIntOrNull() }
        inputValidator.validateWinningNumbers(parsedWinningNumbers)
        return parsedWinningNumbers
    }

    fun inputBonusNumber(): Int {
        val bonusNumber = Console.readLine()
        inputValidator.validateBonusNumber(bonusNumber)
        return bonusNumber.toInt()
    }

}