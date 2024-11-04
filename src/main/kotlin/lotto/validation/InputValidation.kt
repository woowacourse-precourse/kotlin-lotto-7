package lotto.validation

class InputValidation {
    fun typeInt(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요.")
    }

    fun unitOfNumber (number:Int, unit: Int): Int {
        if (number % unit == 0)
            return number
        throw IllegalArgumentException("${unit}원 단위로 입력해주세요.")
    }
}