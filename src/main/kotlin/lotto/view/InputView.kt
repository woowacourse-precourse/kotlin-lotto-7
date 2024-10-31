package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Constants

class InputView {
    fun getLottoAmount(): Int {
        println(Constants.INPUT_BUY_AMOUNT_MESSAGE)
        val input = Console.readLine().toInt()
        return input
    }
}