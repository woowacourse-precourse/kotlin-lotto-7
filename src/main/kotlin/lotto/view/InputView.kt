package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Validator

class InputView {
    fun printInputMoney() {
        println(PRINT_PLEASE_INPUT_MONEY)
        val money = Console.readLine()
        Validator.validatePurchaseMoney(money)
    }


    companion object {
        const val PRINT_PLEASE_INPUT_MONEY = "구입금액을 입력해 주세요."
    }
}