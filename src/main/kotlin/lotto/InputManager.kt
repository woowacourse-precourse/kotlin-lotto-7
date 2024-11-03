package lotto

import camp.nextstep.edu.missionutils.Console.readLine

object InputManager {
    fun requestPayment(): Int {
        println("구입금액을 입력해 주세요.")
        val input = getInput()
        return Parser.parsePaymentInput(input)
    }

    fun requestWinningNumbers(): List<Int> {
        println("\n당첨번호를 입력해 주세요.")
        val input = getInput()
        return Parser.parseWinningNumbersInput(input)
    }

    fun requestBonusNumber(): Int {
        println("\n보너스 번호를 입력해 주세요.")
        val input = getInput()
        return Parser.parseBonusNumberInput(input)
    }

    private fun getInput(): String {
        return readLine()
    }

    private object Parser {
        fun parsePaymentInput(input: String): Int {
            return input.toInt()
        }

        fun parseWinningNumbersInput(input: String): List<Int> {
            return input.split(",").map { it -> it.toInt() }
        }

        fun parseBonusNumberInput(input: String): Int {
            return input.toInt()
        }

    }

    private object Validator {
        fun validatePaymentInput(input: String) {
            
        }

        fun validateWinningNumbersInput(input: String) {

        }

        fun validateBonusNumberInput(input: String) {

        }

    }
}

