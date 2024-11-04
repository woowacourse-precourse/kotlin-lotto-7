package lotto.model

class WinningLotto(val winningNumbers: Lotto, val bonusNumber: Int) {
    init {
        require(bonusNumber !in winningNumbers.getLotto()) { "[ERROR] 보너스 번호는 당첨번호와 중복되지 않아야 합니다." }
        require(bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
    }
}