package view

import camp.nextstep.edu.missionutils.Console

class Input {

    fun purchaseAmountInput(): String {
        println(ENTER_PURCHASE_AMOUNT)
        return Console.readLine()

    }

    fun winningNumberInput(): List<String> {
        println("\n" + ENTER_WINNING_NUMBER)
        return Console.readLine()
            .split(NUMBER_DELIMITER)
            .filter { it.isNotEmpty() }
    }

    fun bonusNumberInput(): String {
        println("\n" + ENTER_BONUS_NUMBER)
        return Console.readLine()
    }

    companion object {
        const val ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        const val ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
        const val ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
        const val NUMBER_DELIMITER = ","
    }
}