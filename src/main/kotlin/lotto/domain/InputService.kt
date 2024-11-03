package lotto.domain

import lotto.model.Lotto
import lotto.resources.LottoConfig
import lotto.resources.Messages.*
import lotto.resources.LottoConfig.*
import lotto.view.GameView

class InputService(private val gameView: GameView) {
    fun <T> readUntilValidInput(infoMessage: String, validator: (String) -> T): T {
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
        require(money > 0L && money % LOTTO_PRICE.value == 0L) { NOT_DIVIDED_BY_UNIT.errorMessage() }
        return money
    }

    fun validateWinNumbers(input: String): Lotto {
        validateEmptyInput(input)
        val winningNumbersText = input.split(",")
        require(winningNumbersText.size == LOTTO_LENGTH.value) { NOT_SIX_NUMBER.errorMessage() }
        require(winningNumbersText.distinct().size == LOTTO_LENGTH.value) {
            DUPLICATE_LOTTO_NUMBER.errorMessage()
        }
        val winningNumbers = winningNumbersText.map {
            it.toIntOrNull() ?: throw IllegalArgumentException(NOT_NUMBER.errorMessage())
        }.sorted()
        require(winningNumbers.all { it in LottoConfig.LOTTO_RANGE }) { INVALID_LOTTO_RANGE.errorMessage() }
        return Lotto(winningNumbers)
    }

    fun validateBonusNumber(input: String, winNumbers: Lotto): Int {
        validateEmptyInput(input)
        val bonusNumber = input.toIntOrNull()
            ?: throw IllegalArgumentException(NOT_NUMBER.errorMessage())
        require(bonusNumber in LottoConfig.LOTTO_RANGE) { INVALID_LOTTO_RANGE.errorMessage() }
        require(bonusNumber !in winNumbers.numbers()) { DUPLICATE_LOTTO_NUMBER.errorMessage() }
        return bonusNumber
    }

    private fun validateEmptyInput(input: String) {
        require(input.isNotBlank() && input.isNotEmpty()) { EMPTY_INPUT.errorMessage() }
    }
}