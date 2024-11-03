package lotto

class DrawingWinningNumbers {
    fun drawingWinningNumbers(): List<Int> {
        val inputWinningNumbers = IOHandler().inputToUser(WINNINGNUMBERINSTRUCTION)
        var winningNumbers: List<Int>

        try {
            winningNumbers = transferType(inputWinningNumbers)

            Validation().checkWinningNumbers(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            winningNumbers = drawingWinningNumbers()
        }

        return winningNumbers
    }

    fun drawingBonusNumber(winningNumbers: WinningNumbers): Int {
        val inputBonusNumber = IOHandler().inputToUser(BONUSNUMBERINSTRUCTION)
        var bonusNumber: Int

        try {
            require(Validation().isDigit(inputBonusNumber)) { EXCEPTIONOFNOTDIGIT }

            bonusNumber = inputBonusNumber.toInt()
            Validation().checkBonusNumber(bonusNumber, winningNumbers.winningNumbers)
        } catch (e: IllegalArgumentException){
            println(e.message)
            bonusNumber = drawingBonusNumber(winningNumbers)
        }
        return bonusNumber
    }

    fun deleteBlank(input: String): String {
        return input.replace(" ", "")
    }

    fun transferType(input: String): List<Int> {
        val tempInput = deleteBlank(input).split(",")

        tempInput.forEach {
            if (!Validation().isDigit(it)) {
                throw IllegalArgumentException(EXCEPTIONOFNOTDIGIT)
            }
        }
        return tempInput.map { it.toInt() }
    }

    companion object {
        const val WINNINGNUMBERINSTRUCTION = "\n당첨 번호를 입력해 주세요."
        const val BONUSNUMBERINSTRUCTION = "\n보너스 번호를 입력해 주세요."
        const val EXCEPTIONOFNOTDIGIT = "[ERROR] 숫자가 아닌 당첨 번호가 존재합니다."
    }
}