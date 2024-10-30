package lotto.View

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getPurchaseAmount(): String {
        println("구매 금액을 입력해주세요.")
        val inputPurchaseAmount = Console.readLine()
        return inputPurchaseAmount
    }

    fun getWinningNumbers(): String {
        println("당첨 번호를 입력해주세요.")
        val winningNumbers = Console.readLine()
        return winningNumbers
    }

    fun getBonusNumber(): String {
        println("보너스 번호를 입력해주세요.")
        val bonusNumber = Console.readLine()
        return bonusNumber
    }
}