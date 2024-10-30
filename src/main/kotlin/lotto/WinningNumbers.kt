package lotto

class WinningNumbers(private val numbers: List<Int>, val bonusNumber: Int) {
    init {
        validateNumbers()
        validateBonusNumbers()
    }

    private fun validateNumbers() {
        require(numbers.size == 6) { "[ERROR] 당첨 번호는 6개여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] 당첨 번호는 중복되면 안됩니다." }
        numbers.forEach { number ->
            require(number <= 45) { "[ERROR] 당첨 번호는 45보다 작거나 같아야 합니다." }
            require(number >= 1) { "[ERROR] 당첨 번호는 1보다 크거나 같아야 합니다." }
        }
    }

    private fun validateBonusNumbers() {
        require(bonusNumber <= 45) { "[ERROR] 보너스 번호는 45보다 작거나 같아야 합니다." }
        require(bonusNumber >= 1) { "[ERROR] 보너스 번호는 1보다 크거나 같아야 합니다." }
        require(numbers.contains(bonusNumber).not()) { "[ERROR] 보너스 번호는 로또 번호들과 중복되면 안됩니다." }
    }

    fun getNumbers() = numbers.toList()
}