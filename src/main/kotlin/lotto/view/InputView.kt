package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getCost(): Int {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                val cost = readCost()
                validateCost(cost)
                return cost
            } catch (e: IllegalArgumentException) {
                println(e.message)  // Print specific error message for invalid cost
            } catch (e: IllegalStateException) {
                println("[ERROR] 시스템 오류가 발생했습니다. 다시 시도해 주세요.")
            }
        }
    }

    private fun readCost(): Int {
        return Console.readLine().toInt()
    }

    private fun validateCost(cost: Int) {
        if (cost <= 0 || cost % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위의 양수여야 합니다.")
        }
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