package lotto

class BonusNumber(private val bonusNumber: Int, private val winningNumbers: List<Int> ) {
    init {
        require(bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(winningNumbers.all { it != bonusNumber }) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }
}