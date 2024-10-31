package lotto.view

class OutputView {
    fun displayLotto(numberOfLotto : Int, lotto : List<List<Int>>){
        println("${numberOfLotto}개를 구매했습니다.")
        lotto.forEach{
            println(it)
        }
    }
}