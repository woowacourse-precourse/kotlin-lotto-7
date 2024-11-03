package lotto.input

import camp.nextstep.edu.missionutils.Console.readLine

object InputManager {
    fun requestPayment(): Int {
        while (true) {
            try {
                println("\n구입금액을 입력해 주세요.")
                val input = getInput()
                InputValidator.validatePaymentInput(input)
                return InputParser.parsePaymentInput(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun requestWinningNumbers(): List<Int> {
        while (true) {
            try {
                println("\n당첨번호를 입력해 주세요.")
                val input = getInput()
                InputValidator.validateWinningNumbersInput(input)
                return InputParser.parseWinningNumbersInput(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun requestBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("\n보너스 번호를 입력해 주세요.")
                val input = getInput()
                InputValidator.validateBonusNumberInput(input, winningNumbers)
                return InputParser.parseBonusNumberInput(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getInput(): String {
        return readLine()
    }

}

