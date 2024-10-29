package lotto.domain

class LottoWinningInfo(val numbers: List<Int>, val bonusNumber: Int) {
    init {
        validateLottoNumbers(numbers)
        validateNumberRange(bonusNumber)
    }

    private fun validateLottoNumbers(numbers: List<Int>) {
        validateLottoNumberSize(numbers)
        for (number in numbers) {
            validateNumberRange(number)
        }
        validateDuplicates(numbers, bonusNumber)
    }

    private fun validateLottoNumberSize(numbers: List<Int>) {
        require(numbers.size == Lotto.ITEM_LENGTH) { Lotto.ERROR_NOT_ITEM_LENGTH }
    }

    private fun validateNumberRange(number: Int) {
        require(number in Lotto.START_NUMBER..Lotto.END_NUMBER) { Lotto.ERROR_NOT_LOTTO_NUMBER }
    }

    private fun validateDuplicates(numbers: List<Int>, bonusNumber: Int) {
        val filterNumbers = numbers.toMutableSet()
        filterNumbers.add(bonusNumber)
        require(filterNumbers.size == Lotto.ITEM_LENGTH + 1) { Lotto.ERROR_NOT_DUPLICATE_NUMBER }
    }
}
