package lotto.view

import lotto.constants.ViewConstant
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun purchaseAmountInput(): String {
        println(ViewConstant.INPUT_GUIDE_PURCHASE_AMOUNT)
        return Console.readLine()
    }

    fun winningNumberInput(): String {
        println(ViewConstant.INPUT_GUIDE_WINNING_NUMBER)
        return Console.readLine()
    }

    fun bonusNumberInput(): String {
        println(ViewConstant.INPUT_GUIDE_BONUS_NUMBER)
        return Console.readLine()
    }
}