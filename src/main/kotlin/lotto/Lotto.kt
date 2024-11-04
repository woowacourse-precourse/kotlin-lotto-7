package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
    }

    companion object {
        fun generateNumbers(): List<Int> {
            return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        }

        // 로또 구입 금액 검증
        fun validatePurchaseAmount(amount: Int) {
            require(amount > 0 && amount % 1000 == 0) { "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다." }
        }

        // 로또 번호 유효성 검증
        fun validateLottoNumbers(numbers: List<Int>) {
            require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
            require(numbers.distinct().size == 6) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
            require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
        }
    }

    // 당첨 번호와 보너스 번호 검증
    fun validateWinningNumbers(winningNumbers: List<Int>, bonusNumber: Int) {
        require(winningNumbers.size == 6) { "[ERROR] 당첨 번호는 6개여야 합니다." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] 당첨 번호는 중복되지 않아야 합니다." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] 당첨 번호는 1부터 45 사이여야 합니다." }
        require(!winningNumbers.contains(bonusNumber)) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
        require(bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이여야 합니다." }
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
