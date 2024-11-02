package lotto

open class NumberValidator {
    fun parseNumberInput(input: String): Int {
        val number = input.toIntOrNull()
        requireNotNull(number) { "[ERROR] 숫자만 입력해주세요." }
        return number
    }

    protected fun validateNumberRange(number: Int) {
        require(number <= 45) { "[ERROR] 보너스 번호는 45보다 작거나 같아야 합니다." }
        require(number >= 1) { "[ERROR] 보너스 번호는 1보다 크거나 같아야 합니다." }
    }
}