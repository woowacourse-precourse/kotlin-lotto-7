package lotto.validation

class InputValidation {
    fun typeInt(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요. ${input}은 숫자가 아닙니다.")
    }

    fun unitOfNumber(number: Int, unit: Int): Int {
        if (number % unit == 0)
            return number
        throw IllegalArgumentException("${unit}원 단위로 입력해주세요.")
    }

    fun lottoNumbersDelimiter(input: String): List<Int> {
        return input.split(",").map {
            typeInt(it)
        }
    }

    fun lottoNumberRange(number: Int): Int {
        require(number in 1..45) { "로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        return number
    }

    private fun lottoNumbersSize(numbers: List<Int>): List<Int> {
        require(numbers.size == 6) { "당첨 번호는 6개의 숫자로 입력해주세요." }
        return numbers
    }

    private fun lottoNumbersNotDuplicate(numbers: List<Int>): List<Int> {
        require(numbers.toSet().size == 6) { "당첨 번호는 중복되면 안됩니다." }
        return numbers
    }

    fun lottoNumbers(numbers: List<Int>): List<Int> {
        return numbers.map {
            lottoNumberRange(it)
        }.also {
            lottoNumbersSize(it)
            lottoNumbersNotDuplicate(it)
        }
    }
}