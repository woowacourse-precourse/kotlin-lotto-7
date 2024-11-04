package lotto


object CheckInputValidation {
    fun validateNull(inputLottoNum: String) {
        require(inputLottoNum.trim().isNotEmpty() || inputLottoNum.trim().isNotBlank()) {
            ErrorMessage.NUMBER_NULL.getMessage()
        }
    }

    fun checkInteger(money: String) {
        if (money.any { !it.isDigit() }) {
            throw IllegalArgumentException(ErrorMessage.NUMBER_INTEGER.getMessage())
        }
    }
}
