package lotto.view

import camp.nextstep.edu.missionutils.Console

class LottoInput {
    fun getPurchasePrice(): String {
        println(INPUT_PURCHASE_PRICE)
        return Console.readLine()
    }

    fun getWinningNumbers(): String {
        println(INPUT_WINNING_NUMBERS)
        return Console.readLine()
    }

    fun getBonusNumber(): String {
        println(INPUT_BONUS_NUMBER)
        return Console.readLine()
    }

    companion object {
        private const val INPUT_PURCHASE_PRICE = "구입 금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    }
}