package lotto.view

import camp.nextstep.edu.missionutils.Console

const val LOTTO_PRICE = 1000

class LottoGameView {
    fun getPurchaseAmount(): Int {
        println(LottoGameViewMessage.PROMPT_PURCHASE_AMOUNT.getMessage())
        return readInput { input ->
            validatePurchaseAmountInput(input)
            val amount = input.toInt()
            validatePurchaseAmount(amount)
            amount
        }
    }

    private fun <T> readInput(inputProcessor: (String) -> T): T {
        return try {
            inputProcessor(readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readInput(inputProcessor)
        }
    }

    private fun readLine(): String {
        return Console.readLine().trim()
    }

    private fun validateEmptyInput(input: String) {
        require(input.isNotBlank()) { LottoGameViewMessage.ERROR_EMPTY_INPUT.getErrorMessage() }
    }

    private fun validatePurchaseAmountInput(input: String) {
        validateEmptyInput(input)
        require(input.matches(Regex("\\d+"))) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_INVALID_CHARACTERS.getErrorMessage())
        }
    }

    private fun validatePurchaseAmount(amount: Int) {
        require(amount % LOTTO_PRICE == 0) {
            throw IllegalArgumentException(LottoGameViewMessage.ERROR_PURCHASE_AMOUNT_UNIT.getErrorMessage())
        }
    }
}
