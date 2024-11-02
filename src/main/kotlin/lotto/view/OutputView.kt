package lotto.view

object OutputView {


    fun printLottoNumbers(lottoNumbers: List<List<Int>>) {
        println("${lottoNumbers.size}개를 구매했습니다.")
        lottoNumbers.forEach { println(it) }
    }

}