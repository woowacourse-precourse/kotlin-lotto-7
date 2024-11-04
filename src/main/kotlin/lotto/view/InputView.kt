package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputPurchaseAmount(): String {
        val purchaseAmount = Console.readLine()
        return purchaseAmount
    }

    fun inputWinningNumbers(): String {
        val winningNumbers = Console.readLine()
        return winningNumbers
    }

    fun inputBonusNumber(): String {
        val bonusNumber = Console.readLine()
        return bonusNumber
    }

}