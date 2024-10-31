package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Validator

class InputView {
    fun printInputMoney(): Int {
        println(PRINT_PLEASE_INPUT_MONEY)
        val money = Console.readLine()
        Validator.validatePurchaseMoney(money)
        println()
        return money.toInt()
    }

    fun printInputWinLotteryNumber(): List<String> {
        println(PRINT_PLEASE_INPUT_WIN_LOTTERY_NUMBER)
        val winLottery = Console.readLine()
        return winLottery.split(",")
    }


    companion object {
        const val PRINT_PLEASE_INPUT_MONEY = "구입금액을 입력해 주세요."
        const val PRINT_PLEASE_INPUT_WIN_LOTTERY_NUMBER = "당첨 번호를 입력해 주세요."
    }
}