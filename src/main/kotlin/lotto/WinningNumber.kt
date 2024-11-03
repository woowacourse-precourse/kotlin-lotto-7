package lotto

class WinningNumber(private val numbers: String) {

    private val winningNumbers = numbers.split(",")

    init {
        require(checkLottoSize()) { "$ERROR $WINNING_SIZE_MESSAGE" }
        require(isNumberInRange()) { "$ERROR $WINNING_NUMBER_DUPLICATE_MESSAGE" }
        require(isDuplicate()) { "$ERROR $WINNING_NUMBER_NOT_IN_RANGE_MESSAGE" }
        require(isNumberOrNull()) { "$ERROR $WINNING_NUMBER_NOT_NUMBER_MESSAGE" }
    }

    private fun isNumberOrNull() = winningNumbers.all { it.toIntOrNull() != null }

    private fun checkLottoSize() = winningNumbers.size == LOTTO_SIZE

    private fun isNumberInRange() = winningNumbers.all { it.toInt() in MIN_NUM..MAX_NUM }

    private fun isDuplicate() = winningNumbers.distinct().size == winningNumbers.size

    fun getWinningNumber(): List<Int> {
        return winningNumbers.map { it.toInt() }.sorted()
    }

    companion object {
        const val LOTTO_SIZE = 6
        const val MIN_NUM = 1
        const val MAX_NUM = 45

        const val ERROR = "[ERROR]"
        const val WINNING_SIZE_MESSAGE = "당첨 번호는 6개여야 합니다."
        const val WINNING_NUMBER_DUPLICATE_MESSAGE = "당첨 번호는 중복될 수 없습니다."
        const val WINNING_NUMBER_NOT_IN_RANGE_MESSAGE = "당첨 번호는 1부터 45사이의 숫자만 가능합니다."
        const val WINNING_NUMBER_NOT_NUMBER_MESSAGE = "당첨 번호는 숫자만 입력 가능합니다."
    }
}