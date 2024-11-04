package lotto.data

class BonusNumber(private val bonusNumber: String, private val winningNumbers: List<Int>) {
    init {
        require(bonusNumber.toIntOrNull() != null) { "[ERROR] 보너스번호는 정수여야 합니다." }
        require(bonusNumber.toInt() in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(winningNumbers.all { it != bonusNumber.toInt() }) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun getNumber() = bonusNumber.toInt()
}