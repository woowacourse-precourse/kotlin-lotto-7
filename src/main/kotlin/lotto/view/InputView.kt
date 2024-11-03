package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        while (true) {
            println("구입금액을 입력해 주세요.")
            val input = Console.readLine()
            try {
                return validatePurchaseAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): List<Int?> {
        while (true) {
            println("\n당첨 번호를 입력해주세요.")
            val input = Console.readLine()
            val numbers = input.split(",")
                .map { it.trim().toIntOrNull() }
            try {
                return validateWinningNumbers(numbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(winningNumbers: List<Int?>): Int {
        while (true) {
            println("\n보너스 번호를 입력해주세요.")
            val bonusNumber = Console.readLine()
            try {
                // 보너스 중복 확인
                return validateBonusNumber(bonusNumber, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validatePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력하세요.")
        require(input.toInt() > 0) { "[ERROR] 구입 금액은 0보다 커야 합니다." }
        require(input.toInt() % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }

        return input.toInt()
    }

    fun validateWinningNumbers(numbers: List<Int?>): List<Int?> {
        require(numbers.size == 6) { "[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다." }
        require(numbers.all { it != null && it in 1..45 }) { "[ERROR] 모든 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] 당첨 번호는 중복 없이 입력해야 합니다." }

        return numbers
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int?>): Int {
        val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 올바른 숫자를 입력하세요.")

        require(bonusNumber in 1 .. 45){"[ERROR] 보너스 번호는 1부터 45 사이여야 합니다."}
        require(bonusNumber !in winningNumbers){"[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."}

        return bonusNumber
    }
}