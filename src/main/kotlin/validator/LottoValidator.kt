package validator

class LottoValidator {
    fun lottoCheck(lottoInput: List<Int>): Boolean {
        var error = false
        try {
            isLottoSix(lottoInput)
            lottoInput.forEach {
                isLottoInRange(it)
            }
            isLottoDuplicate(lottoInput)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
            error = true
        }
        return error
    }

    fun lottoBonusCheck(lottoInput: Int, winNumber: List<Int>): Boolean {
        var error = false
        try {
            isLottoInRange(lottoInput)
            val numbers = winNumber.toMutableList()
            numbers.add(lottoInput)
            isBonusDuplicate(numbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println()
            error = true
        }
        return error
    }

    private fun isLottoInRange(lottoInput: Int) {
        if (lottoInput > 45 || lottoInput < 1) {
            val errorMessage = ErrorMessage.LOTTO_OUT_OF_BOUND
            throw IllegalArgumentException(errorMessage.getMessage())
        }
    }

    private fun isLottoSix(lottoInput: List<Int>) {
        if (lottoInput.size != 6) {
            val errorMessage = ErrorMessage.LOTTO_NOT_SIX
            throw IllegalArgumentException(errorMessage.getMessage())
        }
    }

    private fun isLottoDuplicate(lottoInput: List<Int>) {
        val duplicationRemoval = lottoInput.distinct()
        if (duplicationRemoval.size != 6) {
            val errorMessage = ErrorMessage.LOTTO_DUPLICATE
            throw IllegalArgumentException(errorMessage.getMessage())
        }
    }

    private fun isBonusDuplicate(lottoInput: List<Int>) {
        val duplicationRemoval = lottoInput.distinct()
        if (duplicationRemoval.size != 7) {
            val errorMessage = ErrorMessage.LOTTO_DUPLICATE
            throw IllegalArgumentException(errorMessage.getMessage())
        }
    }
}