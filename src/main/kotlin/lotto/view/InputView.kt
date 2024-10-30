package lotto.view

import camp.nextstep.edu.missionutils.Console

enum class InputMessage(val message: String){
    MONEY("구입 금액을 입력해 주세요."),
    WINNING_NUM("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.");

    fun display(){
        println(message)
    }
}

class InputView {
    fun getMoney(): String {
        InputMessage.MONEY.display()
        return Console.readLine()
    }

    fun getWinningNum(): String {
        InputMessage.WINNING_NUM.display()
        return Console.readLine()
    }

    fun getBonusNum(): String {
        InputMessage.BONUS.display()
        return Console.readLine()
    }
}
