package view

import camp.nextstep.edu.missionutils.Console
import utils.InputMessages.BONUS_NUMBER_INPUT_MESSAGE
import utils.InputMessages.MONEY_INPUT_MESSAGE
import utils.InputMessages.WINNING_NUMBERS_INPUT_MESSAGE
import utils.validator.Validator

object InputView {
    fun getMoney(): Int {
        var money = 0
        do {
            println(MONEY_INPUT_MESSAGE)
            val inputMoney = Console.readLine()

            money = Validator.validateMoney(inputMoney)
        } while (money == 0)
        return money
    }

    fun getWinningNumbers(): List<Int> {
        println(WINNING_NUMBERS_INPUT_MESSAGE)
        val inputWinningNumbers = Console.readLine()

        return Validator.validateWinningNumbers(inputWinningNumbers)
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println(BONUS_NUMBER_INPUT_MESSAGE)
        val inputBonusNumber = Console.readLine()

        return Validator.validateBonusNumber(inputBonusNumber, winningNumbers)
    }

}