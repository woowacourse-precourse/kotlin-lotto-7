package View

import Utils.InputUtils
import Validation.InputValidation
import camp.nextstep.edu.missionutils.Console

object InputView {
    private val input = InputValidation()

    fun getMoney(): Int {
        OutputView.printMoneyMessage()
        val money = Console.readLine().toIntOrNull()?: 0

        return if (input.isValidUnit(money) and input.isValidMoney(money))
            money
        else
            -1
    }
}