package lotto.domain.validator

import lotto.common.LOTTO_NUMBERS_SIZE

class LottoNumbersValidator : LottoNumberValidator() {

    fun validateLottoNumbers(numbers: List<Int>) {
        validateNumbersSize(numbers)
        validateNumbersRange(numbers)
        validateNumbersDuplicate(numbers)
        validateIsAscending(numbers)
    }

    private fun validateNumbersSize(numbers: List<Int>) {
        require(numbers.size == LOTTO_NUMBERS_SIZE) { ERROR_LOTTO_SIZE }
    }

    private fun validateNumbersDuplicate(numbers: List<Int>) {
        require(numbers.distinct().size == numbers.size) { ERROR_DUPLICATE_LOTTO }
    }

    private fun validateNumbersRange(numbers: List<Int>) {
        numbers.forEach { validateNumberRange(it) }
    }

    private fun validateIsAscending(numbers: List<Int>) {
        require(numbers.sorted() == numbers) { ERROR_IS_ASCENDING }
    }

    companion object {
        private const val ERROR_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다."
        private const val ERROR_DUPLICATE_LOTTO = "[ERROR] 로또 번호는 중복되면 안됩니다."
        private const val ERROR_IS_ASCENDING = "[ERROR] 로또 번호는 오름차순 입니다."
    }
}