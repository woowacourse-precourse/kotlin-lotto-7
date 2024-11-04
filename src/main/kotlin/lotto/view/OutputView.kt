package lotto.view

object OutputView {
    fun printNumbers(buy: Int) {
        return println("${buy}개를 구매했습니다.")
    }

    fun printLottoNumbers(numbers: List<List<Int>>) {
        numbers.forEach { println(it.sorted()) }
    }


}