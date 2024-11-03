package lotto.util

class Validator {
    fun getValidPrice(priceInput: String): Int {
        val tempPrice = priceInput.toIntOrException()

        validatePriceRange(tempPrice)
        validatePriceUnit(tempPrice)

        return tempPrice
    }

    fun getValidWinningNumbers(winningNumbersInput: String): List<Int> {
        val tempWinningNumbers = winningNumbersInput.split(DELIMITER).map { it.toIntOrException() }

        validateWinningNumbersSize(tempWinningNumbers)
        tempWinningNumbers.forEach { validateLottoNumberRange(it) }
        validateUniqueNumbers(tempWinningNumbers)

        return tempWinningNumbers
    }

    fun getValidBonusNumber(bonusNumberInput: String): Int {
        val tempBonusNumber = bonusNumberInput.toIntOrException()

        validateLottoNumberRange(tempBonusNumber)

        return tempBonusNumber
    }


    private fun String.toIntOrException() =
        this.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 정수 값을 입력해주세요.")


    private fun validatePriceRange(tempPrice: Int) =
        require(tempPrice in MIN_PRICE..MAX_PRICE) { "[ERROR] 천원-십만원 사이 금액을 입력해주세요." }

    private fun validatePriceUnit(tempPrice: Int) =
        require(tempPrice % MIN_PRICE == 0) { "[ERROR] 1000원 단위로 입력해주세요." }


    private fun validateWinningNumbersSize(tempWinningNumbers: List<Int>) =
        require(tempWinningNumbers.size == WINNING_NUMBERS_SIZE) { "[ERROR] 6개의 숫자를 콤마로 구분해주세요." }

    private fun validateLottoNumberRange(tempWinningNumber: Int) =
        require(tempWinningNumber in MIN_NUMBER..MAX_NUMBER) { "[ERROR] 1-45 사이 숫자를 입력해주세요." }

    private fun validateUniqueNumbers(tempWinningNumbers: List<Int>) =
        require(tempWinningNumbers.size == tempWinningNumbers.toSet().size) { "[ERROR] 중복 숫자를 제거해주세요." }


    companion object {
        private const val MIN_PRICE = 1000
        private const val MAX_PRICE = 100000

        private const val WINNING_NUMBERS_SIZE = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        private const val DELIMITER = ','
    }
}