package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Constants
import lotto.utils.Validator

object InputView {
    fun getLottoAmount(): Int {
        while (true) {
            println(Constants.INPUT_BUY_AMOUNT_MESSAGE)
            val input = Console.readLine()
            try {
                Validator.validateLottoAmount(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            println(Constants.INPUT_WINNING_NUMBERS_MESSAGE)
            val winningNumbers = Console.readLine().split(Constants.NUMBER_DELIMITER)
            try {
                Validator.validateWinningNumbers(winningNumbers)
                return winningNumbers.map { it.toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println(Constants.INPUT_BONUS_NUMBER_MESSAGE)
            val bonusNumber = Console.readLine()
            try {
                Validator.validateBonusNumber(bonusNumber, winningNumbers)
                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}