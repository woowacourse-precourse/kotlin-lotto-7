package View

import Utils.InputUtils
import Validation.InputValidation
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
}