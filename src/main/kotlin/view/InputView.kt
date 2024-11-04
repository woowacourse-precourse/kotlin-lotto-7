package view

import validation.InputValidation
import camp.nextstep.edu.missionutils.Console

object InputView {
    private val input = InputValidation()

    fun getMoney(): Int {
        while(true) {
            OutputView.printMoneyMessage()
            val money = Console.readLine().toIntOrNull() ?: 0

            if (input.isValidUnit(money) and input.isValidMoney(money))
                return money
        }
    }

    fun getWinNumbers(): List<Int> {
        while(true) {
            OutputView.printWinNumberMessage()
            val winNumbers = Console.readLine().split(",")
                .map { it.trim().toInt() }

            if (input.isValidWinNumbers(winNumbers) and input.isinValidRange(winNumbers))
                return winNumbers
        }
    }

    fun getBounusNumber(winNumbers: List<Int>): Int {
        while(true) {
            OutputView.printBonusNumberMessage()
            val bonusNumber = Console.readLine().toIntOrNull() ?: 0

            if (input.isUniqueBonusNumber(winNumbers, bonusNumber) and input.isinValidRange(listOf(bonusNumber)))
                return bonusNumber
        }
    }
}