package lotto.view

import lotto.model.LottoResult

class OutputView {
    fun displayLotto(lotto : List<List<Int>>){
        println("${lotto.size}개를 구매했습니다.")
        lotto.forEach{
            println(it)
        }
    }
    fun displayResult(){
        println("3개 일치 - ${LottoResult.fifth}개")
        println("4개 일치 - ${LottoResult.fourth}개")
        println("5개 일치 - ${LottoResult.third}개")
        println("5개 일치 - ${LottoResult.second}개")
        println("6개 일치 - ${LottoResult.first}개")
        println("총 수익률은 ${"%.1f".format(LottoResult.priceRatio)}")
        println(LottoResult.priceRatio)

    }
}