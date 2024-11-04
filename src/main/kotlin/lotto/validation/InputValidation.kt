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

    fun lotteryNumbersDelimiter(input: String): List<Int> {
        return input.split(",").map {
            typeInt(it)
        }
    }

    fun lotteryNumberRange(number: Int): Int {
        require(number in 1..45) { "로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        return number
    }
}