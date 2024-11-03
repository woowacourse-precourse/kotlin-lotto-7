package lotto.model

class WinningLotto(private val winningNumbers: Lotto, private val bonusNumber: Int) {
    init {
        require(bonusNumber !in winningNumbers.getLotto()) { "[ERROR] 보너스 번호는 당첨번호와 중복되지 않아야 합니다." }
    }

    fun getWinningNumbers(): Lotto {
        return winningNumbers
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }
}