package lotto.input

import camp.nextstep.edu.missionutils.Console.readLine

object InputManager {
    fun requestPayment(): Int {
        println("구입금액을 입력해 주세요.")
        val input = getInput()
        return parsePaymentInput(input)
    }

    fun requestWinningNumbers(): List<Int> {
        println("\n당첨번호를 입력해 주세요.")
        val input = getInput()
        return parseWinningNumbersInput(input)
    }

    fun requestBonusNumber(): Int {
        println("\n보너스 번호를 입력해 주세요.")
        val input = getInput()
        return parseBonusNumberInput(input)
    }

    private fun parsePaymentInput(input: String): Int {
        return input.toInt()
    }

    private fun parseWinningNumbersInput(input: String): List<Int> {
        return input.split(",").map { it -> it.toInt() }
    }

    private fun parseBonusNumberInput(input: String): Int {
        return input.toInt()
    }

    private fun getInput(): String {
        return readLine()
    }
}

