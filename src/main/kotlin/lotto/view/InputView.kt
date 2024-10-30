package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputValidator

class InputView {
    private val inputValidator = InputValidator()

    fun inputPurchaseAmount(): Int {
        val purchaseAmount = Console.readLine()
        inputValidator.validatePurchaseAmount(purchaseAmount)
        return purchaseAmount.toInt()
    }

    fun inputWinningNumbers(): List<Int?> {
        val winningNumbersInput = Console.readLine()
        val parsedWinningNumbers = winningNumbersInput.split(",").map { it.trim().toIntOrNull() }
        inputValidator.validateWinningNumbers(parsedWinningNumbers)
        return parsedWinningNumbers
    }

}