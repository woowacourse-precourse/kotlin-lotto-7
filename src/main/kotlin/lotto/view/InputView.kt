package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine().toInt()

        return validatePurchaseAmount(input)
    }

    fun validatePurchaseAmount(input: Int): Int {
        require(input > 0) { "[ERROR] 구입 금액은 0보다 커야 합니다." }
        require(input % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
        return input
    }

    fun readWinningNumbers(): List<Int?> {
        println("당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() }

        return validateWinningNumbers(numbers)
    }

    fun validateWinningNumbers(numbers: List<Int?>): List<Int?> {
        require(numbers.size == 6) { "[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다." }
        require(numbers.all { it != null && it in 1..45 }) { "[ERROR] 모든 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] 당첨 번호는 중복 없이 입력해야 합니다." }

        return numbers
    }

    fun readBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonus = Console.readLine().toInt()

        return validateBonusNumber(bonus)
    }

    fun validateBonusNumber(bonus: Int): Int {
        require(bonus in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }

        return bonus
    }
}

