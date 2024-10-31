package lotto.domain

class WinningLotto (private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] 당첨 번호는 6개여야 합니다." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] 당첨 번호는 중복될 수 없습니다." }
        require(bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(!winningNumbers.contains(bonusNumber)) { "[ERROR] 당첨 번호와 보너스 번호는 같을 수 없습니다." }
    }


    fun getWinningNumbers(): List<Int> = winningNumbers

    fun getBonusNumber(): Int = bonusNumber
}
