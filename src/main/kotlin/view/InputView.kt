package view

import camp.nextstep.edu.missionutils.Console
import lotto.model.lotto.Lotto
import lotto.model.lotto.Money
import lotto.model.lotto.WinningNumbers

class InputView {
    fun getPurchaseMoney(): Int {
        var money = 0
        while (true) {
            try {
                print("구매 금액을 입력하세요. ")
                val input = Console.readLine().trim()

                money = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.")
                Money(money)

                return money
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                println()
                println("당첨 번호를 입력해 주세요.")

                val numbers = Console.readLine().split(",").map { it.trim() }.filter { it.isNotEmpty() }.map {
                    it.toIntOrNull() ?: throw NumberFormatException("[ERROR] 숫자 형식이 아닙니다. 유효한 형식으로 입력해 주세요.")
                }
                Lotto(numbers)

                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: NumberFormatException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(winningNumbers : List<Int>): Int {
        while (true){
            try {
                println()
                println("보너스 번호를 입력해 주세요.")
                val bonusNumber = Console.readLine()!!.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자가 아닙니다. 다시 입력해주세요")

                WinningNumbers(winningNumbers, bonusNumber)

                return bonusNumber
            }catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }
}
