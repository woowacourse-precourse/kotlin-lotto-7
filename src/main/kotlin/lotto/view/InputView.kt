package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView() {

    fun inputPurchaseAmount(): Int {
        while (true) {
            println("구입금액을 입력해 주세요.")
            val input = Console.readLine()
        }
    }
}