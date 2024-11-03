package lotto

import camp.nextstep.edu.missionutils.Console

class View {
    private val broadcast = Broadcast()

    fun inputPayment(): Payment {
        broadcast.printInputPaymentMassage()
        val input = Console.readLine()

        return Payment(input)
    }
}