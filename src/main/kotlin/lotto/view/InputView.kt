package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.")
    }

    fun getWinningNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요")
        val input = Console.readLine()
        return input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다") }
    }
}