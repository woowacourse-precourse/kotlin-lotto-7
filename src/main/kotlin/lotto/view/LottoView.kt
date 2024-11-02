package lotto.view

import camp.nextstep.edu.missionutils.Console

class LottoView {
    fun displayWinningNumbers(winningNumbers: List<Int>) {
        println("당첨 번호: $winningNumbers")
    }

    fun displayBonusNumber(bonusNumber: Int) {
        println("보너스 번호: $bonusNumber")
    }

    fun displayError(message: String) {
        println("[ERROR] $message")
    }

    fun readWinningNumbers(): List<Int?> {
        println()
        println("당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.trim().toIntOrNull() }

        if (numbers.any { it == null }) {
            displayError("당첨 번호는 정수만 입력해야 합니다.")
            return emptyList()
        }

        return numbers
    }

    fun readBonusNumber(): Int {
        println()
        println("보너스 번호를 입력해 주세요.")
        val input = Console.readLine()

        if (input.isEmpty()) {
            displayError("보너스 번호는 비워둘 수 없습니다.")
            return -1
        }

        return input.toIntOrNull() ?: run {
            displayError("유효한 정수를 입력해야 합니다.")
            -1
        }
    }

    fun displayPurchaseCount(count: Int) {
        println()
        println("${count}개를 구매했습니다.")
    }
}
