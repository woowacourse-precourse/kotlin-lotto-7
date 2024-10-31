package utils.validator

object Validator {

    fun validateMoney(inputMoney: String): Int {

        MoneyValidator.SHOULD_BE_NUMBER.validate(inputMoney)

        MoneyValidator.SHOULD_BE_POSITIVE.validate(inputMoney)

        MoneyValidator.SHOULD_BE_1000_UNIT.validate(inputMoney)

        MoneyValidator.SHOULD_BE_UNDER_MAX.validate(inputMoney)

        return inputMoney.toInt()
    }

    fun validateWinningNumbers(inputWinningNumbers: String): List<Int> {
        val winningNumbers = inputWinningNumbers.split(",")

        WinningNumbersValidator.SHOULD_BE_SIX_COUNT.validate(winningNumbers)

        WinningNumbersValidator.SHOULD_BE_NUMBER.validate(winningNumbers)

        WinningNumbersValidator.SHOULD_BE_1_TO_45_NUMBER.validate(winningNumbers)

        WinningNumbersValidator.SHOULD_NOT_BE_DUPLICATE.validate(winningNumbers)

        return winningNumbers.map { it.toInt() }

    }

    fun validateBonusNumber(inputBonusNumber: String, winningNumbers: List<Int>): Int {

        BonusNumberValidator.SHOULD_BE_NUMBER.validate(inputBonusNumber)

        BonusNumberValidator.SHOULD_BE_1_TO_45_NUMBER.validate(inputBonusNumber)

        BonusNumberValidator.SHOULD_NOT_BE_DUPLICATE.validate(inputBonusNumber, winningNumbers)

        return inputBonusNumber.toInt()
    }


}