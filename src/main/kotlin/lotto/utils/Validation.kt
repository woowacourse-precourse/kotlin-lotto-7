package lotto.utils

object Validation {
    fun isValidRange(vararg numbers: Int): Boolean = numbers.map { it in 1..45 }.all { it }

    fun isNotDuplicated(winningNumber: Set<Int>, bonusNumber: Int): Boolean = !winningNumber.contains(bonusNumber)
}

object Price {
    fun validate(inputPrice: String): Int {
        val price = inputPrice.toIntOrNull() ?: throw IllegalArgumentException()
        require(price > 0)
        require(price % 1000 == 0)
        return price
    }
}

object WinningNumber {
    fun validate(inputWinningNumber: String): Set<Int> {
        val winningNumber = inputWinningNumber.split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()
        require(winningNumber.size == 6)
        require(Validation.isValidRange(*winningNumber.toIntArray()))
        return winningNumber
    }
}

object BonusNumber {
    fun validate(inputBonusNumber: String, winningNumber: Set<Int>): Int {
        val bonusNumber = inputBonusNumber.toIntOrNull() ?: throw IllegalArgumentException()
        require(Validation.isValidRange(bonusNumber))
        require(Validation.isNotDuplicated(winningNumber, bonusNumber))
        return bonusNumber
    }
}