package lotto

class Lotto(private val numbers: List<List<Int>>) {
    init {
        numbers.forEach { lotto -> println(lotto.sorted()) }
    }
}