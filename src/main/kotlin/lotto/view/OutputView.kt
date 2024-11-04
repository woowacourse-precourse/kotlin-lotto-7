package lotto.view

object OutputView {
    fun printLotto(lottoList: MutableList<List<Int>>, purchase: Int){
        println("${purchase}개를 구매했습니다.")
        lottoList.forEach { println(it) }
        println()
    }

    fun printResult(resultArray: IntArray, yield: Double) {
        println("당첨 동계")
        println("---")
        println("3개 일치 (5,000원) - ${resultArray[0]}개")
        println("4개 일치 (50,000원) - ${resultArray[1]}개")
        println("5개 일치 (1,500,000원) - ${resultArray[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${resultArray[4]}개")
        println("6개 일치 (2,000,000,000원) - ${resultArray[3]}개")
        println("총 수익률은 ${yield}%입니다.")
    }
}