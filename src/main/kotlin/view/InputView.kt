package view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getPurchaseMoney(): Int {
        var money = 0
        while (true) {
            try {
                print("구매 금액을 입력하세요: ")
                val input = Console.readLine().trim()

                money = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.")
                validationMoneyInput(money)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return money
    }

    private fun validationMoneyInput(money: Int) {
        require(money > 0) { "[ERROR] 금액은 0보다 커야 합니다." }
        require(money % 1000 == 0) { "[ERROR] 금액은 1000원 단위로 입력 가능합니다." }
    }
}
