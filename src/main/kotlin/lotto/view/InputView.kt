package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount() : Int {
        println("구입금액을 입력해 주세요.")
        return Console.readLine().toInt()
    }

    fun readWinningNumbers(): List<String> {
        println("\n당첨 번호를 입력해주세요.")
        return Console.readLine().split(",")
    }

    fun readBonusNumbers():Int{
        println("\n보너스 번호를 입력해주세요.")
        return Console.readLine().toInt()
    }

    fun validatePurchaseAmount(){}
    fun validateWinningNumbers(){}
    fun validateBonusNumbers(){}
}