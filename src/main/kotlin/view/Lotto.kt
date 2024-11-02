package view

class Lotto(private val numbers: List<List<Int>>) {
    init {
        numbers.forEach { lotto -> println(lotto.sorted()) }
    }
}
//구매한 금액만큼 무작위로또번호 출력