package lotto

import camp.nextstep.edu.missionutils.Console

class View {
    fun inputPayment(): Payment {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()

        return Payment(input)
    }
}