package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 구입 금액은 자연수로만 입력할 수 있습니다")
    }
}
