package validator

class LottoValidator {
    fun lottoCheck(lottoInput: List<Int>) {
        try {
            isLottoSix(lottoInput)
            lottoInput.forEach {
                isLottoInRange(it)
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    fun lottoBonusCheck(lottoInput: List<Int>) {
        try {
            isLottoBonusOne(lottoInput)
            isLottoInRange(lottoInput[0])
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
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

    private fun isLottoBonusOne(lottoInput: List<Int>) {
        if (lottoInput.size != 1) {
            val errorMessage = ErrorMessage.LOTTO_BONUS_NOT_ONE
            throw IllegalArgumentException(errorMessage.getMessage())
        }
    }
}