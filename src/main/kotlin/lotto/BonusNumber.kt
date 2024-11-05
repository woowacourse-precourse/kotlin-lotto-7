package lotto

class BonusNumber(private val number: String, private val lotto: WinningNumber) {
    init {
        require(isNumber()) { "$ERROR $NOT_NUMBER_MESSAGE" }
        require(isNumberInRange()) { "$ERROR $BONUS_NUMBER_NOT_IN_RANGE_MESSAGE" }
        require(isContains()) { "$ERROR $BONUS_NUMBER_CONTAINS_MESSAGE" }
    }

    private fun isNumber() = number.toIntOrNull() != null

    private fun isNumberInRange() = number.toInt() in MIN_NUM..MAX_NUM

    private fun isContains(): Boolean {
        val lottoNumber = getWinningNumber()
        val bonusNumber = number.toInt()
        return !lottoNumber.contains(bonusNumber)
    }

    fun getWinningNumber(): List<Int> {
        return lotto.getWinningNumber()
    }

    fun getBonusNumber(): Int {
        return number.toInt()
    }

    companion object {
        const val MIN_NUM = 1
        const val MAX_NUM = 45

        const val ERROR = "[ERROR]"
        const val NOT_NUMBER_MESSAGE = "보너스 번호는 숫자여야 합니다."
        const val BONUS_NUMBER_CONTAINS_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다."
        const val BONUS_NUMBER_NOT_IN_RANGE_MESSAGE = "보너스 번호는 1부터 45사이의 숫자여야 합니다."
    }
}