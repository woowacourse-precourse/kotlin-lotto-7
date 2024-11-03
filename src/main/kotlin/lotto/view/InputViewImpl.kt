package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputViewImpl : InputView {

    override fun readPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }

    override fun readWinningNumbers(): String {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine()
    }

    override fun readBonusNumber(): String {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }
}