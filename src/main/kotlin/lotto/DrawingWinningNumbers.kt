package lotto

class DrawingWinningNumbers {
    fun drawingWinningNumbers(): List<Int> {
        val input = IOHandler().inputToUser(WINNINGNUMBERINSTRUCTION)
        val winningNumbers = transferType(input)

        Validation().checkWinningNumbers(winningNumbers)
        return winningNumbers
    }

    fun deleteBlank(input: String): String {
        return input.replace(" ", "")
    }

    fun transferType(input: String): List<Int> {
        val tempInput = input.split(",")

        tempInput.forEach {
            if (!Validation().isDigit(it)) {
                throw IllegalArgumentException(EXCEPTIONOFNOTDIGIT)
            }
        }
        return tempInput.map { it.toInt() }
    }

    companion object {
        const val WINNINGNUMBERINSTRUCTION = "당첨 번호를 입력해 주세요."
        const val EXCEPTIONOFNOTDIGIT = "숫자가 아닌 당첨 번호가 존재합니다."
    }
}