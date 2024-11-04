package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getCost(): Int {
        println("구입금액을 입력해 주세요.")
        return Console.readLine().toInt()
    }

    fun getWinNum(): List<Int> {
        println("당첨 번호를 입력해주세요.")
        return Console.readLine().split(",").map { it.toInt()}
    }

    fun getBonusNum(): Int {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine().toInt()
    }
}