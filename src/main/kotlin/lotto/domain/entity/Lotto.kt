package lotto.domain.entity

class Lotto(private val numbers: List<Int>) {
    fun getNumbers() = numbers.toList()
}
