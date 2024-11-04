package lotto.model.lotto

class WinningNumbers(val winningNumbers: List<Int>,val bonusNumber: Int) {
    init {
        require(bonusNumber !in winningNumbers) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
        require(bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1~45 사이여야 합니다." }
    }
}