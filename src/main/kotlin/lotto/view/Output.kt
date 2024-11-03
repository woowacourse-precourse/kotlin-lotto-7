package lotto.view

import lotto.util.Constants
import kotlin.math.round

class Output {
    fun printWinningDetails() {

    }

    fun printReturnRate(rate: Double) {
        println(Constants.RETURN_RATE + round(rate * 10) / 10 + Constants.IS_PERCENT)
    }

    fun printMoneyToInput() {
        println(Constants.INSERT_MONEY)
    }

    fun printPurchaseDetails(money: Int) {
        println("${money / 1000}" + Constants.INSERT_MONEY_RESULT)
    }

    fun printWinningNumberToInput() {
        println(Constants.INSERT_WINNIG_NUNBER)
    }

    fun printBonusNumberToInput() {
        println(Constants.INSERT_BONUS_NUMBER)
    }

}