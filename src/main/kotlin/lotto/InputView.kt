package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputLottoPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }
}