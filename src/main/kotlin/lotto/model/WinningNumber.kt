package lotto.model

class WinningNumber(private val numbers: List<Int>) {
    init {
        require(numbers.size <= 7) { "[ERROR] 최대 7개까지 가능합니다." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] 중복된 값이 도출되었습니다" }
    }

    fun addBonusNumber(bonusNumber: Int): WinningNumber {
        val updatedNumbers = numbers + bonusNumber
        return WinningNumber(updatedNumbers)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }
}