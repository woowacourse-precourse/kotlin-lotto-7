package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun printInputMoney() {
        println(PRINT_PLEASE_INPUT_MONEY)
        val money = Console.readLine()

    }


    companion object {
        const val PRINT_PLEASE_INPUT_MONEY = "구입금액을 입력해 주세요."
    }
}