package lotto

class OutputView {
    fun printLottoCount(count: Int, myLotto: List<List<Int>>) {
        println("\n${count}개를 구매했습니다.")
        myLotto.forEach { lottoNumbers ->
            println(lottoNumbers.joinToString(prefix = "[", postfix = "]", separator = ", "))
        }
    }
}