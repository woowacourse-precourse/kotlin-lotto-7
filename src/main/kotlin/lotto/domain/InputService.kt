package lotto.domain

import lotto.model.Lotto
import lotto.resources.Messages.*
import lotto.view.GameView

class InputService(private val gameView: GameView) {
    fun <T> readValidInput(infoMessage: String, validator: (String) -> T): T {
        gameView.showMessage(infoMessage)
        while (true) {
            try {
                val input = validator(gameView.readLine())
                gameView.showBlankLine()
                return input
            } catch (e: IllegalArgumentException) {
                gameView.showMessage(e.message ?: INVALID_ERROR.errorMessage())
            }
        }
    }

    fun validateMoney(input: String): Long {
        validateEmptyInput(input)
        val money = input.toLongOrNull()
            ?: throw IllegalArgumentException(NOT_NUMBER.errorMessage())
        require(money > 0L && money % MONEY_UNIT == 0L) { NOT_DIVIDED_BY_UNIT.errorMessage() }
        return money
    }

    fun validateWinNumbers(input: String): Lotto {
        validateEmptyInput(input)
        val winningNumbersText = input.split(",")
        require(winningNumbersText.size == LOTTO_LENGTH) { NOT_SIX_NUMBER.errorMessage() }
        require(winningNumbersText.distinct().size == LOTTO_LENGTH) { DUPLICATE_LOTTO_NUMBER.errorMessage() }
        val winningNumbers = winningNumbersText.map {
            it.toIntOrNull() ?: throw IllegalArgumentException(NOT_NUMBER.errorMessage())
        }.sorted()
        require(winningNumbers.all { it in LOTTO_RANGE }) { INVALID_LOTTO_RANGE.errorMessage() }
        return Lotto(winningNumbers)
    }

    fun validateBonusNumber(input: String, winNumbers: Lotto): Int {
        validateEmptyInput(input)
        val bonusNumber = input.toIntOrNull()
            ?: throw IllegalArgumentException(NOT_NUMBER.errorMessage())
        require(bonusNumber in LOTTO_RANGE) { INVALID_LOTTO_RANGE.errorMessage() }
        require(bonusNumber !in winNumbers.numbers()) { DUPLICATE_LOTTO_NUMBER.errorMessage() }
        return bonusNumber
    }

    private fun validateEmptyInput(input: String) {
        require(input.isNotBlank() && input.isNotEmpty()) { EMPTY_INPUT.errorMessage() }
    }

    companion object {
        const val MONEY_UNIT = 1_000
        const val LOTTO_LENGTH = 6
        const val LOTTO_START_VALUE = 1
        const val LOTTO_END_VALUE = 45
        val LOTTO_RANGE = LOTTO_START_VALUE..LOTTO_END_VALUE
    }
}