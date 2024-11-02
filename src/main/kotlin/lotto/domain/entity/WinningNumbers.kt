package lotto.domain.entity

class WinningNumbers(private val numbers: List<Int>, val bonusNumber: Int) {
    fun getNumbers() = numbers.toList()
}