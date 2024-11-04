package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getCost(): Int {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                val cost = readValidCost()
                validateCost(cost)
                return cost
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: IllegalStateException) {
                println("[ERROR] 시스템 오류가 발생했습니다. 다시 시도해 주세요.")
            }
        }
    }

    private fun readValidCost(): Int {
        while (true) {
            try {
                val input = Console.readLine().toInt()
                if (input % 1000 != 0) {
                    throw IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위이어야 합니다.")
                }
                return input
            } catch (e: NumberFormatException) {
                println("[ERROR] 잘못된 입력입니다. 숫자를 입력해주세요.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
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

    fun getBonusNum(winNumbers: Set<Int>): Int {
        while (true) {
            try {
                println("보너스 번호를 입력해 주세요.")
                val bonusNum = Console.readLine().toInt()

                // Check if the bonus number is within the valid range
                if (bonusNum !in 1..45) {
                    throw IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.")
                }

                // Check for duplicates with the winning numbers
                if (winNumbers.contains(bonusNum)) {
                    throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
                }

                return bonusNum
            } catch (e: NumberFormatException) {
                println("[ERROR] 잘못된 입력입니다. 숫자를 입력해주세요.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}