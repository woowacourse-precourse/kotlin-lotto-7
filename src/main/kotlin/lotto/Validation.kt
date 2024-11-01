package lotto

object Validation {
    fun isValidRange(vararg numbers: Int): Boolean = numbers.map { it in 1..45 }.all { it }
}