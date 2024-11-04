package lotto.model

class WinningLotto(val winningNumbers: Lotto, val bonusNumber: Int) {
    init {
        require(bonusNumber !in winningNumbers.getLotto()) { BONUS_NUMBER_DUPLICATE_ERROR }
        require(bonusNumber in 1..45) { BONUS_NUMBER_RANGE_ERROR }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val ERROR_MESSAGE = "[ERROR]"
        private const val BONUS_NUMBER_DUPLICATE_ERROR = "$ERROR_MESSAGE 보너스 번호는 당첨번호와 중복되지 않아야 합니다."
        private const val BONUS_NUMBER_RANGE_ERROR = "$ERROR_MESSAGE 보너스 번호는 ${MIN_NUMBER}부터 $MAX_NUMBER 사이의 숫자여야 합니다."
    }
}