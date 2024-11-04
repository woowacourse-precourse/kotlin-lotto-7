package validator

class StringValidator : StringGenerator {
    override fun validate(value: String) {
        require(value.all { it.isDigit() }) {
            STRING_ERROR_FORMAT.format(value)
        }
    }

    companion object {
        const val STRING_ERROR_FORMAT = "입력받은 값은 숫자여야 합니다."
    }
}