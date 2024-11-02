package lotto.model

class BonusNumber {
    fun getBonusNumber(bonusNumber: Int, winningNumbers: List<Int>): Boolean {
        return isValidateBonusNumber(bonusNumber, winningNumbers)
    }

    private fun isValidateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>): Boolean {
        return when {
            bonusNumber < 1 || bonusNumber > 45 -> {
                println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
                false
            }
            bonusNumber in winningNumbers -> {
                println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
                false
            }
            else -> true
        }
    }
}
