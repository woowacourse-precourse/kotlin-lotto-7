package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        validateNumber(input)
        return input.toInt()
    }

    fun readWinningNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        return parseNumbers(input)
    }

    fun readBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val input = Console.readLine()
        validateNumber(input)
        return input.toInt()
    }

    private fun validateNumber(input: String) {
        require(input.matches(Regex("\\d+"))) { "[ERROR] 숫자만 입력 가능합니다." }
    }

    private fun parseNumbers(input: String): List<Int> =
        input
            .split(",")
            .map { it.trim() }
            .also { numbers ->
                require(numbers.size == Lotto.LOTTO_SIZE) { "[ERROR] 로또 번호는 6개여야 합니다." }
            }.map { number ->
                validateNumber(number)
                number.toInt()
            }
}
