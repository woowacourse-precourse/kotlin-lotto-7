package lotto.model

import lotto.view.LottoView

class WinningNumber {
    fun getWinningNumber(view: LottoView): List<Int> {
        while (true) {
            val numbers = view.readWinningNumbers()
            if (isValidNumberscheck(numbers)) {
                return numbers.filterNotNull()
            }
        }
    }

    private fun isValidNumberscheck(numbers: List<Int?>): Boolean {
        if (numbers.any { it == null } || numbers.size != 6) {
            println("[ERROR] 당첨 번호는 6개의 정수만 입력해야 합니다.")
            return false
        }
        if (numbers.any { it !in 1..45 }) {
            println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.")
            return false
        }
        val distinctNumbers = numbers.distinct()
        if (distinctNumbers.size != numbers.size) {
            println("[ERROR] 당첨 번호에는 중복이 있을 수 없습니다.")
            return false
        }
        return true
    }
}
