package lotto.view

class OutputView {
    fun displayLotto(lotto : List<List<Int>>){
        println("${lotto.size}개를 구매했습니다.")
        lotto.forEach{
            println(it)
        }
    }
}