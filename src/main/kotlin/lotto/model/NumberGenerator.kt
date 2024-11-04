package lotto.model

interface NumberGenerator {
    fun generateNumber(min: Int, max: Int, count: Int): List<Int>
}
