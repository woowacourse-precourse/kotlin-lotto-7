package lotto

import camp.nextstep.edu.missionutils.Console

class View {
    private val broadcast = Broadcast()

    fun inputPayment(): Payment {
        broadcast.printInputPaymentMassage()
        val input = Console.readLine()

        return Payment(input)
    }

    fun inputWinningNumber(): WinningNumber {
        broadcast.printWinningNumberMessage()
        val input = Console.readLine()
        return WinningNumber(input)
    }

    fun inputBonusNumber(winningNumber: WinningNumber): BonusNumber {
        broadcast.printInputBonusNumberMessage()
        val input = Console.readLine()
        return BonusNumber(input, winningNumber)
    }
}