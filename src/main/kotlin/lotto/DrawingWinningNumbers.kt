package lotto

class DrawingWinningNumbers {
    fun drawingWinningNumbers(): List<Int> {
        val inputWinningNumbers = IOHandler().inputToUser(WINNINGNUMBERINSTRUCTION)
        val winningNumbers = transferType(inputWinningNumbers)

        Validation().checkWinningNumbers(winningNumbers)
        return winningNumbers
    }

    fun drawingBonusNumber(winningNumbers: WinningNumbers): Int {
        val inputBonusNumber = IOHandler().inputToUser(BONUSNUMBERINSTRUCTION)
        require(Validation().isDigit(inputBonusNumber)) { EXCEPTIONOFNOTDIGIT }
        val bonusNumber = inputBonusNumber.toInt()

        Validation().checkBonusNumber(bonusNumber, winningNumbers.winningNumbers)
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
        const val WINNINGNUMBERINSTRUCTION = "당첨 번호를 입력해 주세요."
        const val BONUSNUMBERINSTRUCTION = "보너스 번호를 입력해 주세요."
        const val EXCEPTIONOFNOTDIGIT = "[ERROR] 숫자가 아닌 당첨 번호가 존재합니다."
    }
}