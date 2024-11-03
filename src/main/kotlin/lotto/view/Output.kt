package lotto.view

import lotto.util.Constants
import lotto.util.Prize
import java.text.DecimalFormat
import kotlin.math.round

class Output {
    fun printWinningDetails(winningDetails:List<Int>) {
        println(Constants.WINNING_DETAIL)
        println(Constants.DASH)
        val prize = Prize.entries
        val dec = DecimalFormat("#,###")
        for ((index,count) in winningDetails.reversed().withIndex()){
            val foundPrize = prize.find { it.rank == index+1 }!!
            when (foundPrize.bonus){
                true -> println("${foundPrize.hit}개 일치, 보너스 볼 일치 (${dec.format(foundPrize.prize)}원) - ${count}개")
                false -> println("${foundPrize.hit}개 일치 (${dec.format(foundPrize.prize)}원) - ${count}개")
            }
        }
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