package lotto.utils

object Validation {
    fun isValidRange(vararg numbers: Int): Boolean = numbers.map { it in 1..45 }.all { it }

    fun isNotDuplicated(winningLotto: Set<Int>, bonusNumber: Int): Boolean = !winningLotto.contains(bonusNumber)
}