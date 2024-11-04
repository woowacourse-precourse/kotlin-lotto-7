package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.parser.Parser
import lotto.validator.Validator

class InputView(private val validator: Validator, private val parser: Parser) {

    fun inputPurchaseAmount(): Int {
        while (true) {
            println("구입금액을 입력해 주세요.")
            val input = Console.readLine()
            try {
                validator.validatePurchaseAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }

            val amount = parser.parsePurchaseAmount(input)
            println()

            return amount
        }
    }

    fun inputWinningNumbers(): List<Int> {
        while (true) {
            println("당첨 번호를 입력해 주세요.")
            val input = Console.readLine()
            val numbers = parser.parseWinningNumbers(input)

            try {
                validator.validateWinningNumbers(numbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
            println()

            return numbers
        }
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println("보너스 번호를 입력해 주세요.")
            val input = Console.readLine()
            val bonusNumber = parser.parseBonusNumber(input)

            try {
                validator.validateBonusNumber(bonusNumber, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                throw e
            }
            println()

            return bonusNumber
        }
    }
}