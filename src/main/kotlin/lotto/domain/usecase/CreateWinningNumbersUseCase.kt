package lotto.domain.usecase

import lotto.domain.validator.BonusNumberValidator
import lotto.domain.validator.LottoNumberValidator
import lotto.domain.entity.WinningNumbers

class CreateWinningNumbersUseCase(
    private val lottoNumbersValidator: LottoNumberValidator = LottoNumberValidator(),
    private val bonusNumberValidator: BonusNumberValidator = BonusNumberValidator()
) {
    fun execute(numbersInput: () -> String, bonusNumberInput: () -> String): WinningNumbers {
        val numbers = getWinningNumbers(numbersInput)
        val bonusNumber = getBonusNumber(bonusNumberInput, numbers)
        return WinningNumbers(numbers, bonusNumber)
    }

    private fun getWinningNumbers(numbersInput: () -> String): List<Int> {
        while (true) {
            try {
                val input = numbersInput()
                val numbers = parseNumbersInput(input)
                validateNumbers(numbers)
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun parseNumbersInput(input: String): List<Int> {
        return input.split(",").map { numberInput ->
            lottoNumbersValidator.parseNumberInput(numberInput)
        }
    }

    private fun validateNumbers(numbers: List<Int>) {
        lottoNumbersValidator.validateLottoNumbers(numbers)
    }

    private fun getBonusNumber(bonusNumberInput: () -> String, numbers: List<Int>): Int {
        while (true) {
            try {
                val input = bonusNumberInput()
                val bonusNumber = bonusNumberValidator.parseNumberInput(input)
                bonusNumberValidator.validateBonusNumber(bonusNumber, numbers)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
