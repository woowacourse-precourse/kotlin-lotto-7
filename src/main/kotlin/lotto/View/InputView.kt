package lotto.View

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getPurchaseAmount(): String {
        println("구매 금액을 입력해주세요.")
        val inputPurchaseAmount = Console.readLine()
        println()
        return inputPurchaseAmount
    }

    fun getFirstPrizeNumbers(): String {
        println("당첨 번호를 입력해주세요.")
        val firstPrizeNumbers = Console.readLine()
        println()
        return firstPrizeNumbers
    }

    fun getBonusNumber(): String {
        println("보너스 번호를 입력해주세요.")
        val bonusNumber = Console.readLine()
        println()
        return bonusNumber
    }
}