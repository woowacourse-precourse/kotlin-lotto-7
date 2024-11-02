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
        // 입력된 숫자 수가 6이 아닌 경우
        if (numbers.size != 6) {
            println("[ERROR] 당첨 번호는 6개의 정수만 입력해야 합니다.")
            return false
        }

        // 1~45 범위가 아닌 숫자가 포함된 경우
        if (numbers.any { it !in 1..45 }) {
            println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.")
            return false
        }

        // 중복된 숫자가 포함된 경우
        if (numbers.distinct().size != numbers.size) {
            println("[ERROR] 당첨 번호에는 중복이 있을 수 없습니다.")
            return false
        }

        // 모든 조건을 만족하는 경우
        return true
    }

}
