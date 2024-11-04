package validator

import lotto.LottoConstants.DELIMITER

class WinningNumberValidator(
    private val numbersValidator: StringGenerator = StringValidator(),
    private val numberSizeValidator: NumbersValidator = RangeValidator(),
    private val lottoGenerate: NumbersValidator = LottoGenerator(),
    private val lottoRange: NumbersValidator = RangeValidator()
) : StringGenerator {
    override fun validate(value: String) {
        validateContainsComma(value)
        val numbers = value.validateAndConvertToNumbers()
        numberSizeValidator.validate(numbers)
        lottoGenerate.validate(numbers)
        lottoRange.validate(numbers)
    }

    private fun String.validateAndConvertToNumbers() = split(DELIMITER)
        .map { it.trim() }
        .onEach { numbersValidator.validate(it) }
        .map { it.toInt() }

    private fun validateContainsComma(value: String) {
        require(value.contains(DELIMITER)) {
            COMMA_ERROR_MESSAGE
        }
    }

    companion object {
        const val COMMA_ERROR_MESSAGE = ",로 숫자를 구분해주세요!"
    }
}