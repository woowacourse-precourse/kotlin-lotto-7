package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputMessages.INPUT_BONUS_NUMBER
import lotto.util.InputMessages.INPUT_PURCHASE_PRICE
import lotto.util.InputMessages.INPUT_WINNING_NUMBERS

class LottoInput {
    fun getPurchasePrice(): String {
        println(INPUT_PURCHASE_PRICE)
        return Console.readLine()
    }

    fun getWinningNumbers(): String {
        println(INPUT_WINNING_NUMBERS)
        return Console.readLine()
    }

    fun getBonusNumber(): String {
        println(INPUT_BONUS_NUMBER)
        return Console.readLine()
    }
}