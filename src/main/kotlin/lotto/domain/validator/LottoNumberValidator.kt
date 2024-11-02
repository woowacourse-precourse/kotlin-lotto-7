package lotto.domain.validator

class LottoNumberValidator : NumberValidator() {

    fun validateLottoNumbers(numbers: List<Int>) {
        validateNumbersSize(numbers)
        validateNumbersRange(numbers)
        validateNumbersDuplicate(numbers)
    }

    private fun validateNumbersSize(numbers: List<Int>) {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    private fun validateNumbersDuplicate(numbers: List<Int>) {
        require(numbers.distinct().size == numbers.size) { "[ERROR] 로또 번호는 중복되면 안됩니다." }
    }

    private fun validateNumbersRange(numbers: List<Int>) {
        numbers.forEach { validateNumberRange(it) }
    }
}