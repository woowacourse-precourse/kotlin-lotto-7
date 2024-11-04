package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputPurchasePrice(): String {
        printInputPurchasePriceMessage()
        val purchasePrice = Console.readLine()
        return purchasePrice
    }

    fun inputWinningNumbers(): String {
        printInputWinningNumbersMessage()
        val winningNumbers = Console.readLine()
        return winningNumbers
    }

    fun inputBonusNumber(): String {
        printInputBonusNumberMessage()
        val bonusNumber = Console.readLine()
        return bonusNumber
    }

    private fun printInputPurchasePriceMessage() = println("구입금액을 입력해 주세요.")

    private fun printInputWinningNumbersMessage() = println("${NEW_LINE}당첨 번호를 입력해 주세요.")

    private fun printInputBonusNumberMessage() = println("${NEW_LINE}보너스 번호를 입력해 주세요.")

    companion object {
        private const val NEW_LINE = "\n"
    }

}
