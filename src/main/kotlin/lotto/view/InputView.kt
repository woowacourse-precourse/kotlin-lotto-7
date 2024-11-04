package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.parser.Parser
import lotto.validator.Validator

class InputView(private val validator: Validator, private val parser: Parser) {

    fun inputPurchaseAmount(): Int {
        while (true) {
            println("구입금액을 입력해 주세요.")
            val input = Console.readLine()
            validator.validatePurchaseAmount(input)

            val amount = parser.parsePurchaseAmount(input)
            println()

            return amount
        }
    }

    fun inputWinningNumbers(): List<Int> {
        while (true) {
            println("당첨 번호를 입력해 주세요.")
            val input = Console.readLine()
        }
    }
}