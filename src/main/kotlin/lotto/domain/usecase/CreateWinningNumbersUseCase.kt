package lotto.domain.usecase

import lotto.domain.entity.WinningNumbers
import lotto.extention.parseToIntOrThrow

class CreateWinningNumbersUseCase {
    fun execute(numbersInput: () -> String): WinningNumbers {
        while (true) {
            try {
                val numbers = parseNumbersInput(numbersInput())
                return WinningNumbers(numbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun parseNumbersInput(input: String): List<Int> {
        return input.split(DELIMITER).map { numberInput ->
            numberInput.parseToIntOrThrow()
        }
    }

    companion object {
        private const val DELIMITER = ","
    }
}
